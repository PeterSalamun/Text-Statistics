package appLogicTests.TextOperations;

import java.util.regex.Pattern;

public class Ratio extends GeneralOperations{
    //TODO pomer medzi samohlaskami a spoluhlaskami

    private int vowels;
    private int conso;
    private int other;
    private int space;
    private Pattern vowelsPattern;
    private Pattern consonantPattern;

    public Ratio() {
        initializeFields();
    }

    private void initializeFields() {
        vowels = 0;
        conso = 0;
        other = 0;
        space = 0;
        vowelsPattern = Pattern.compile("[aeiouy]+", Pattern.CASE_INSENSITIVE);
        consonantPattern = Pattern.compile("[ďťňľčžšĺŕ]+", Pattern.CASE_INSENSITIVE);
    }

    public void addSentence(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ')
                space++;
            else if (isVowel(c))
                vowels++;
            else if (isConsonant(c))
                conso++;
            else
                other++;
        }
    }

    private boolean isVowel(char str) {
        return vowelsPattern.matcher(Character.toString(str)).matches();
    }

    private boolean isConsonant(char c) {
        return (((c >= 'a' && c <= 'z') && !isVowel(c)) || consonantPattern.matcher(Character.toString(c)).matches());
    }

    public int getVowels() {
        return vowels;
    }

    public int getConsonants() {
        return conso;
    }

    public int getSpaces() {return space;}

    public int getOther() {return other;}
}
