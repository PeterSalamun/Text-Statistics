package ui.Buttons;

import ui.AppInterface;
import ui.NotGIStuff.ResetApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends BasicButton {

    private static final String NAME = "Reset";
    private static final int COLUMN = 1;
    private static final int LINE = 1;
    private static final int HEIGHT = 1;
    private static final int WIDTH = 1;
    private static final int[] INSETS = new int[]{15, 10, 10, 23};

    public ResetButton(AppInterface app, JComponent parent) {
        super(app, parent, NAME, COLUMN, LINE, HEIGHT, WIDTH, INSETS);
    }

    protected void createButton() {
        button = new JButton(name);
        customizeButton();
    }

    protected void addListener() {
        button.addActionListener(new ResetButtonClickHandler());
    }

    private class ResetButtonClickHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            new ResetApp(getApp());
        }
    }
}
