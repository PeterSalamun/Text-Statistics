package ui.Pane;

import appLogicTests.TextOperations.*;
import ui.AppInterface;
import ui.Tool;

import javax.swing.*;
import java.awt.*;

public class TextPane extends Tool {
//TODO pridat bocnu scrolovaciu listu
    private static final String NAME = null;
    private static final int COLUMN = 0;
    private static final int LINE = 0;
    private static final int HEIGHT = 1;
    private static final int WIDTH = 4;
    private static final int[] INSETS = new int[]{5, 0, 0, 0};
    private static Dimension areaSize = null;

    private JTextPane textPane;
    private Font font;

    public TextPane(AppInterface app, JComponent parent) {
        super(app, parent, NAME, COLUMN, LINE, HEIGHT, WIDTH, INSETS);
        initializeFields();

    }

    private void initializeFields() {
        textPane = new JTextPane();
        font = new Font("Times New Roman", Font.BOLD, 14);
        setPaneSize();
        customizeTextArea();
    }

    private void setPaneSize() {
        int width = AppInterface.getWIDTH();
        int height = AppInterface.getHEIGHT();
        int hCut = 200;
        int wCut = 100;
        areaSize = new Dimension((width- wCut), (height- hCut));
    }

    public JTextPane getTextPane() {
        return textPane;
    }

    private void customizeTextArea() {
        textPane.setPreferredSize(areaSize);
        textPane.setFocusable(false);
        textPane.setEditable(false);
        textPane.setVisible(true);
        textPane.setBackground(Color.BLACK);
        textPane.setForeground(Color.GREEN);
        textPane.setFont(font);
        textPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        textPane.setText("\n\t\t      TEXT STATISTICS\n\n\t\t           =========\n\t\t" +
                "       Upload your text!\n\t\t           =========");
    }

    public void fillTheTextArea(GeneralOperations[] generalOP) {
        TextComb comb = new TextComb(generalOP);
        String fillUp = comb.getCombedText();
        textPane.setText(fillUp);
    }

    public void eraseTheContent() {
        textPane.setText("");
    }

    @Override
    protected void addListener() {
    }
}
