package ui.Buttons;

import ui.AppInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends BasicButton {

    private static final String NAME = "Exit";
    private static final int COLUMN = 1;
    private static final int LINE = 2;
    private static final int HEIGHT = 1;
    private static final int WIDTH = 1;
    private static final int[] INSETS = new int[]{15,10,10,10};

    public ExitButton(AppInterface app, JComponent parent) {
        super(app, parent, NAME, COLUMN, LINE, HEIGHT, WIDTH, INSETS);
    }

    protected void createButton() {
        button = new JButton(name);
        customizeButton();
    }

    protected void addListener() {
        button.addActionListener(new ExitButtonClickHandler());
    }

    private class ExitButtonClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
