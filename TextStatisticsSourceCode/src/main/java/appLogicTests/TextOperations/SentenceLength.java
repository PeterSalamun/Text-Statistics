package appLogicTests.TextOperations;

public class SentenceLength extends GeneralOperations{

    private double avgSenLen;
    private double sentCount;
    private double lenWithoutSpace;
    private double totalLength;


    public SentenceLength() {
        avgSenLen = 0.0;
        sentCount = 0;
        lenWithoutSpace = 0;
        totalLength = 0;
    }

    public void addSentence(String sentence) {
        sentCount++;
        totalLength += sentence.length();
        lenWithoutSpace += sentence.replace(" ", "").length();
    }

    public double getAvgSenLenWithoutSpaces() {
        return getRound(lenWithoutSpace/sentCount, 0);
    }
    public double getAvgSenLenWithSpaces() {return getRound(totalLength/sentCount, 0);}

    public double getSentenceCount() {
        return  sentCount;
    }
}
