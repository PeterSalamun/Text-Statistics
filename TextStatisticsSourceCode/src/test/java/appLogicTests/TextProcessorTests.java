package appLogicTests;

import appLogicTests.TextOperations.Frequency;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextProcessorTests {

    private TextProcessor proces;
    private final String[] text = new String[]{
            "Ahoj.",
            "Ja som Peter."
    };

    private final String[] text2 = new String[]{};

    @Before
    public void setUp() {
        proces = new TextProcessor(text);
    }

    @Test
    public void testGeneralOperations() {
        assertTrue(proces.getTextAnalysis().length == 4);
        assertTrue(proces.getTextAnalysis()[0] instanceof Frequency);
    }


    @Test
    public void testGetSentenceLength() {
        assertEquals(proces.getSentenceLength().getSentenceCount(), 4.0, 0.0);
    }

    @Test
    public void testGetFrequency() {
        assertFalse(proces.getFrequency().getFrequencyWithoutSpace().isEmpty());
        assertTrue(proces.getFrequency().getFrequencyWithSpace().containsKey("s"));
        assertFalse(proces.getFrequency().getFrequencyWithSpace().containsKey("ô"));
        assertEquals(proces.getFrequency().getFrequencyWithSpace().get("a"), 11.11, 0.01);

        proces = new TextProcessor(text2);
        assertTrue(proces.getFrequency().getFrequencyWithoutSpace().isEmpty());
        assertFalse(proces.getFrequency().getFrequencyWithSpace().containsKey("s"));
        assertFalse(proces.getFrequency().getFrequencyWithSpace().containsKey("ô"));
        assertNull(proces.getFrequency().getFrequencyWithSpace().get("a"));
    }

    @Test
    public void testGetRatio() {
        assertEquals(proces.getRatio().getConsonants(), 8, 0.1);
        assertEquals(proces.getRatio().getVowels(), 6, 0.1);
        assertEquals(proces.getRatio().getOther(), 2, 0.1);
        assertEquals(proces.getRatio().getSpaces(), 2, 0.1);

        proces = new TextProcessor(text2);
        assertEquals(proces.getRatio().getConsonants(), 0, 0.1);
        assertEquals(proces.getRatio().getVowels(), 0, 0.1);
        assertEquals(proces.getRatio().getOther(), 0, 0.1);
        assertEquals(proces.getRatio().getSpaces(), 0, 0.1);
    }

    @Test
    public void testWordLength() {
        assertEquals(proces.getWordLength().getAvgLength(), 3.5,0.1);
        assertEquals(proces.getWordLength().getAvgWordsPerSent(), 2.0,0.1);
        assertEquals(proces.getWordLength().getWordsCount(), 4, 0.1);
        assertEquals(proces.getWordLength().getFleschIndex(), 77.91, 0.01);
        proces = new TextProcessor(text2);
        assertEquals(proces.getWordLength().getAvgLength(), 0,0.1);
        assertEquals(proces.getWordLength().getAvgWordsPerSent(), 0,0.1);
        assertEquals(proces.getWordLength().getWordsCount(), 0, 0.1);
        assertEquals(proces.getWordLength().getFleschIndex(), 0, 0.01);
    }
}
