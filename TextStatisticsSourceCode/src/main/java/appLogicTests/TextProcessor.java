package appLogicTests;

import appLogicTests.TextOperations.*;

public class TextProcessor {

    private String[] text;
    private SentenceLength sentenceLength;
    private Frequency frequency;
    private Ratio ratio;
    private WordLength wordLength;

    public TextProcessor(String[] text) {
        this.text = text;
        initializeFields();
        processText();
    }

    private void initializeFields() {
        sentenceLength = new SentenceLength();
        frequency = new Frequency();
        ratio = new Ratio();
        wordLength = new WordLength();
    }

    private void processText() {
        //TODO skusit cez thread - multithreading
        for(String sentence: text) {
            sentence = sentence.toLowerCase();
            sentenceLength.addSentence(sentence);
            frequency.addSentence(sentence);
            ratio.addSentence(sentence);
            wordLength.addSentence(sentence);

        }
    }

    public GeneralOperations[] getTextAnalysis() {
        GeneralOperations[] generalOP = new GeneralOperations[] {getFrequency(), getRatio(),
                getSentenceLength(), getWordLength()};

        return generalOP;
    }

    public SentenceLength getSentenceLength() {
        return sentenceLength;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public Ratio getRatio() {
        return ratio;
    }

    public WordLength getWordLength() {
        return wordLength;
    }
}
