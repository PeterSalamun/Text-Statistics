package appLogicTests.TextOperationsTests;

import appLogicTests.TextOperations.Ratio;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class RatioTests {

    String c1, c2, c3, c4;

    @Before
    public void setUp() {
        c1 = "a";
        c2 = " ";
        c3 = "v";
        c4 = "[";
    }

    @Test
    public void isVowelOrConsonantTest() {
        Ratio ratio = new Ratio();
        assertEquals(ratio.getConsonants(), 0);
        ratio.addSentence(c1);
        assertEquals(ratio.getConsonants(), 0);
        ratio.addSentence(c2);
        assertEquals(ratio.getConsonants(), 0);
        ratio.addSentence(c3);
        assertEquals(ratio.getConsonants(), 1);
        ratio.addSentence(c4);
        assertEquals(ratio.getConsonants(), 1);
    }

    @Test
    public void isVowelTest() {
        Ratio ratio = new Ratio();
        assertEquals(ratio.getVowels(), 0);
        ratio.addSentence(c1);
        assertEquals(ratio.getVowels(), 1);
        ratio.addSentence(c2);
        assertEquals(ratio.getVowels(), 1);
        ratio.addSentence(c3);
        assertEquals(ratio.getVowels(), 1);
        ratio.addSentence(c4);
        assertEquals(ratio.getVowels(), 1);
    }

    @Test
    public void isOtherTest() {
        Ratio ratio = new Ratio();
        assertEquals(ratio.getOther(), 0);
        ratio.addSentence(c1);
        assertEquals(ratio.getOther(), 0);
        ratio.addSentence(c2);
        assertEquals(ratio.getOther(), 0);
        ratio.addSentence(c3);
        assertEquals(ratio.getOther(), 0);
        ratio.addSentence(c4);
        assertEquals(ratio.getOther(), 1);
    }

    @Test
    public void isSpaceTest() {
        Ratio ratio = new Ratio();
        assertEquals(ratio.getSpaces(), 0);
        ratio.addSentence(c1);
        assertEquals(ratio.getSpaces(), 0);
        ratio.addSentence(c2);
        assertEquals(ratio.getSpaces(), 1);
        ratio.addSentence(c3);
        assertEquals(ratio.getSpaces(), 1);
        ratio.addSentence(c4);
        assertEquals(ratio.getSpaces(), 1);
    }
}
