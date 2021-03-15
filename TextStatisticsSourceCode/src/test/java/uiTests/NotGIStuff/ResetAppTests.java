package uiTests.NotGIStuff;

import org.junit.Before;
import org.junit.Test;
import ui.AppInterface;
import ui.NotGIStuff.ResetApp;
import ui.Pane.TextPane;

import static org.junit.Assert.assertEquals;

public class ResetAppTests {

    private ResetApp reset;
    private AppInterface app;
    private String[] text = new String[] {"Ahoj. Hello World. Už sa to rúti."};

    @Before
    public void setUp() {
        app = new AppInterface();
    }

    @Test
    public void resetTheAppTest() {
        String t = "\n\t\t      TEXT STATISTICS\n\n\t\t           =========\n\t\t" +
                "       Upload your text!\n\t\t           =========";
        assertEquals(app.getTextPane().getTextPane().getText(), t);
        app.getButtonsArray().get(0).getButton().doClick();
        app.getButtonsArray().get(1).getButton().doClick();
        assertEquals(app.getTextPane().getTextPane().getText(), t);

    }
}
