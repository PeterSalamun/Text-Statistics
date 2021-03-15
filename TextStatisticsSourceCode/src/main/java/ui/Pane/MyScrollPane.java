package ui.Pane;

import ui.AppInterface;
import ui.Tool;

import javax.swing.*;
import java.awt.*;

public class MyScrollPane extends Tool {

    private TextPane textArea;
    private JScrollPane scrollPane;
    private static final String NAME = null;
    private static final int COLUMN = 0;
    private static final int LINE = 0;
    private static final int HEIGHT = 1;
    private static final int WIDTH = 4;
    private static final int[] INSETS = new int[]{5, 0, 0, 0};
    private static Dimension areaSize = null;

    public MyScrollPane(AppInterface app, JComponent parent) {
        super(app, parent, NAME, COLUMN, LINE, HEIGHT, WIDTH, INSETS);
        initializeFields();
        addChildToParent(parent, scrollPane);
    }

    private void initializeFields() {
        scrollPane = new JScrollPane();
        textArea = new TextPane(app, scrollPane);
        setPaneSize();
        customizePane();
    }

    private void customizePane() {
        scrollPane.setPreferredSize(areaSize);
        scrollPane.createVerticalScrollBar();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(textArea.getTextPane());
    }

    private void setPaneSize() {
        int width = AppInterface.getWIDTH();
        int height = AppInterface.getHEIGHT();
        int hCut = 125;
        int wCut = 35;
        areaSize = new Dimension((width- wCut), (height- hCut));
    }

    public TextPane getTextPane() {
        return textArea;
    }

    @Override
    protected void addListener() {

    }
}
