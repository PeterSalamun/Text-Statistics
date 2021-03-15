package appLogicTests.TextOperationsTests;

import appLogicTests.TextOperations.*;
import appLogicTests.TextProcessor;
import appLogicTests.TextProcessorTests;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TextCombTests {

    private TextComb comb;
    private TextProcessor proces;
    private GeneralOperations[] gO;
    private String[] text = new String[]{
            "Jeden chudobný človek mal od svojej prvej ženy jednu dcéru.",
            "Nezadlho, ako mu tá prvá žena umrela, vzal si druhú ženu, a tá tiež mala od svojho muža dcéru, rovesnicu " +
                    "tamtej.",
            "To dievča, čo od tej prvej ženy mal, bolo veľmi statočnô a poriadno; ale toto druhô nedobre sa správalo a " +
                    "nikdy nič robiť nechcelo.",
            "A predsa tá macocha vždy len svoju dievku vychvaľovala, že aká to robotnica, aká to statočná dievka; a tú " +
                    "svoju pastorkyňu bila a naháňala a ustavične ju hrešila, že aký to darobník, aký leňoch."
            };

    @Before
    public void setUp() {
        proces = new TextProcessor(text);
        gO = new GeneralOperations[]{
                proces.getFrequency(),
                proces.getRatio(),
                proces.getSentenceLength(),
                proces.getWordLength()
                };
    }

    @Test
    public void testGetCombedText() {
        comb = new TextComb(gO);
        assertTrue(comb.getCombedText().length() > 100);
    }
}
