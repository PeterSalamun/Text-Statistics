package ui.Buttons;

import ui.AppInterface;
import ui.Tool;

import javax.swing.*;
import java.awt.*;

public abstract class BasicButton extends Tool {

    protected JButton button;
    protected final Dimension BUTTONSIZE = new Dimension(125, 25);
    protected Font buttonFont;

    public BasicButton(AppInterface app, JComponent parent, String name, int column, int line, int height, int width,
                       int[] insets) {
        super(app, parent, name, column, line, height, width, insets);

        initializeFields();
        createButton();
        addChildToParent(parent, button);
        addListener();
    }

    private void initializeFields() {
        buttonFont = new Font("Cambria", Font.BOLD, 14);
    }

    protected abstract void createButton();

    protected void customizeButton() {
        button.setPreferredSize(BUTTONSIZE);
        button.setFont(buttonFont);
    }

    public JButton getButton() {return button;}

}
