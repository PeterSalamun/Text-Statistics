package appLogicTests.TextOperations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordLength extends GeneralOperations {

    private double wordLength;
    private double wordsCount;
    private double avgLength;
    private double syllabelsCount;
    private double sentences;

    public WordLength() {
        fieldsInitialize();
    }

    private void fieldsInitialize() {
        wordLength = 0;
        wordsCount = 0;
        avgLength = 0;
        syllabelsCount = 0;
        sentences = 0;
    }

    private int countSyllabels(String word) {
        String pattern = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher match = Pattern.compile(pattern).matcher(word);
        int count = 0;

        while (match.find())
            count++;

        return Math.max(count, 1);
    }

    public void addSentence(String sentence) {
        String[] words = sentence.split("[\\W]+");
        if (words.length != 0) {
            sentences++;
            for (String word : words) {
                syllabelsCount += countSyllabels(word);
                wordLength += word.length();
                wordsCount++;
            }
        }
    }

    public double getAvgLength() {
        if (wordsCount == 0)
            return 0;
        return getRound(wordLength / wordsCount, 2);

    }

    public double getFleschIndex() {
        return round(206.835 - 1.015 * (wordsCount / sentences) - 84.6 * (syllabelsCount / wordsCount), 2);
    }

    public double getAvgWordsPerSent() {
        return getRound(wordsCount/sentences, 2);
    }

    public double getWordsCount() {
        return wordsCount;
    }
}