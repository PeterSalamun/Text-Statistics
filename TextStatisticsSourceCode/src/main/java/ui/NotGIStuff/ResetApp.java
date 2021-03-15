package ui.NotGIStuff;

import ui.AppInterface;
import ui.Pane.TextPane;

public class ResetApp {

    private AppInterface app;
    private TextPane textArea;

    public ResetApp(AppInterface app) {
        this.app = app;
        initializeFields();
        resetTheApp();
    }

    private void initializeFields() {
        textArea = app.getTextPane();
    }

    private void resetTheApp() {
        textArea.eraseTheContent();
        textArea.getTextPane().setText("\n\t\t      TEXT STATISTICS\n\n\t\t           =========\n\t\t" +
                "       Upload your text!\n\t\t           =========");
    }


}
