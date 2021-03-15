package appLogicTests.TextOperations;

import java.util.TreeMap;

public class Frequency extends GeneralOperations{
    //TODO frekvencia pismen v texte

    TreeMap<String, Double> characters;
    int charNumWithSpaces;
    int charNumWithoutSpaces;

    public Frequency() {
        initialize();
    }

    private void initialize() {
        charNumWithSpaces = 0;
        charNumWithoutSpaces = 0;
        characters = new TreeMap<>();
    }

    public void addSentence(String sentence) {
        charNumWithSpaces += sentence.length();
        for (int i = 0; i < sentence.length(); i++) {
            String c = Character.toString(sentence.charAt(i)).toLowerCase();
            if (characters.containsKey(c)) {
                double count = characters.get(c);
                characters.put(c, count + 1);
            } else {
                characters.put(c, 1.0);
            }
        }
        charNumWithoutSpaces += sentence.replace(" ", "").length();
    }

    public TreeMap<String, Double> getFrequencyWithoutSpace() {
        TreeMap<String, Double> freq = new TreeMap<>();
        String cond = " ";
        fillTreeMap(freq, charNumWithoutSpaces, cond);
        return freq;
    }

    public TreeMap<String, Double> getFrequencyWithSpace() {
        TreeMap<String, Double> freq = new TreeMap<>();
        String cond = null;
        fillTreeMap(freq, charNumWithSpaces, cond);
        return freq;
    }

    private TreeMap<String, Double> fillTreeMap(TreeMap<String, Double> map, int totalCount, String cond) {
        for (String s : characters.keySet())
            if (!s.equals(cond)) {
                map.put(s, getPercentage(characters.get(s), totalCount, 2));
            }
        return map;
    }

}
