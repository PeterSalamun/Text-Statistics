package appLogicTests.TextOperationsTests;

import appLogicTests.TextOperations.GeneralOperations;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralOperationsTests {

    GeneralOperations gO;

    @Before
    public void setUp() {
        gO = new GeneralOperations();
    }

    @Test
    public void percentageTest() {
        assertEquals(gO.getPercentage(2, 4, 2), 50, 0.01);
        assertEquals(gO.getPercentage(-4, 4, 2), 0, 0.01);
        assertEquals(gO.getPercentage(0, 4, 2), 0, 0.01);
        assertEquals(gO.getPercentage(5, 4, 2), 125, 0.01);
        assertEquals(gO.getPercentage(4, 4, 2), 100, 0.01);

    }

    @Test
    public void roundTest() {
        assertEquals(gO.getRound(1.123456, 2), 1.12, 0.001);
        assertEquals(gO.getRound(1.654321, 1), 1.7, 0.01);
        assertEquals(gO.getRound(1.135468, 3), 1.135, 0.0001);
        assertEquals(gO.getRound(1.9768, 0), 2, 0.001);
    }
}
