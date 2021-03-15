package appLogicTests.TextOperationsTests;

import appLogicTests.TextOperations.SentenceLength;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceLengthTests {

    String s1, s2, s3;

    @Before
    public void setUp() {
        s1 = "Ahoj ja som pes.";
        s2 = "";
        s3 = "Nie.";
    }

    @Test
    public void getAvgSenLenWithSpacesTest() {
        SentenceLength sL1 = new SentenceLength();
        sL1.addSentence(s1);
        assertEquals(sL1.getAvgSenLenWithSpaces(), 16, 0.1);

        SentenceLength sL2 = new SentenceLength();
        sL2.addSentence(s2);
        assertEquals(sL2.getAvgSenLenWithSpaces(), 0, 0.1);

        SentenceLength sL3 = new SentenceLength();
        sL3.addSentence(s3);
        assertEquals(sL3.getAvgSenLenWithSpaces(), 4, 0.1);
    }
}
