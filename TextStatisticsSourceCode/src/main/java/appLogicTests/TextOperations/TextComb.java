package appLogicTests.TextOperations;

import java.text.MessageFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class TextComb extends GeneralOperations{

    private Frequency frequency;
    private Ratio ratios;
    private SentenceLength sentenceLength;
    private WordLength wordLength;
    private String finalText;


    public TextComb(GeneralOperations[] generalOperations) {
        initializeFields(generalOperations);
        textCombing();
    }

    private void initializeFields(GeneralOperations[] generalOperations) {
        finalText = " ==================== TEXT STATISTICS ==================== " +
                "\n\n  The text you have uploaded has:\n";

        for (GeneralOperations opp : generalOperations) {
            if (opp instanceof Frequency)
                frequency = (Frequency) opp;
            else if (opp instanceof Ratio)
                ratios = (Ratio) opp;
            else if (opp instanceof SentenceLength)
                sentenceLength = (SentenceLength) opp;
            else if (opp instanceof WordLength)
                wordLength = (WordLength) opp;
            else {
            }
            //TODO throws exception;
        }

    }

    private void textCombing() {
        finalText += combingSentence() +
                combingWords() +
                combingRatio() +
                combingFrequency();
    }

    private String combingSentence() {
        String sent = "\n  1. SENTENCE(s)" +
                "\n      Sentence(s) count:\t\t\t\t" + sentenceLength.getSentenceCount() +
                "\n      Avg. number of characters in sentence (no spaces):\t" + sentenceLength.getAvgSenLenWithoutSpaces() +
                "\n      Avg. number of characters in sentence (with spaces):\t" + sentenceLength.getAvgSenLenWithSpaces() +
                addDivider();
        return sent;
    }

    private String combingWords() {
        String word = "\n  2. WORD(s)" +
                "\n      Word(s) count:\t\t\t\t" + wordLength.getWordsCount() +
                "\n      Avg. word length (aprox.):\t\t\t" + getRound(wordLength.getAvgLength(), 0) +
                "\n      Avg.words count per Sentence (aprox.):\t\t" + getRound(wordLength.getAvgWordsPerSent(), 0) +
                "\n      Flesch reading-ease test score:\t\t\t" + wordLength.getFleschIndex() +
                addDivider();

        return word;
    }

    private String combingRatio() {
        String ratio = "\n  3. RATIO(s)" +
                "\n      Vowel(s):\t\t\t\t" + ratios.getVowels() +
                "\n      Consonant(s):\t\t\t\t" + ratios.getConsonants() +
                "\n      Other character(s):\t\t\t" + ratios.getOther() +
                "\n      Space(s):\t\t\t\t" + ratios.getSpaces() +
                addDivider();

        return ratio;
    }

    private String combingFrequency() {
        TreeMap<String, Double> freq = frequency.getFrequencyWithSpace();
        return compilingText(freq);
    }

    private String compilingText(Map<String, Double> freq) {
        String temp = "\n  4. FREQUENCIES\n     ";
        int leng = 0;


        for (String character : freq.keySet()) {
            String toAdd = MessageFormat.format("{0}{1}{2}{3}", "'", character, "' = " + fitTheInput(freq.get(character)), " %\t");
            if (leng + toAdd.length() > 55)
                temp += "\n     ";

            temp += toAdd;
            leng = temp.substring(temp.lastIndexOf("\n")).length();
        }
        return temp;
    }

    private String fitTheInput(Double num) {
        return fillTheGap(addZero(num));
    }

    private String addZero(Double num) {
        String str = Double.toString(num);
        if (str.substring(str.indexOf('.')).length() == 2) {
            return str += "0";
        }
        return str;
    }

    private String fillTheGap(String str) {
        if (str.substring(0, str.indexOf('.')).length() == 1)
            return "  " + str;
        return str;
    }

    private String addDivider() {
        return "\n\n\t\t     ===============\n";
    }

    public String getCombedText() {
        return finalText;
    }
}
