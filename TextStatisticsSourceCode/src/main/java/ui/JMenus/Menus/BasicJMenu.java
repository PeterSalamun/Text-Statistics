package ui.JMenus.Menus;

import ui.AppInterface;

import javax.swing.*;
import java.awt.*;

public abstract class BasicJMenu extends JMenu {

    protected JMenu menu;
    protected JMenuBar parentBar;
    protected String name;
    protected Font menuFont;
    protected AppInterface app;

    public BasicJMenu(JMenuBar parentBar, String name) {

        this.parentBar = parentBar;
        this.name = name;
        initializeFields();
        createJMenu();
    }

    private void initializeFields() {
        menuFont = new Font("Cambria", Font.PLAIN, 13);
    }

    protected void createJMenu() {
        menu = new JMenu(name);
        customizeJMenu();
        addJMenuToJMenuBar();
    }

    private void customizeJMenu() {
        menu.setFont(menuFont);
    }

    protected void addJMenuToJMenuBar() {
        parentBar.add(menu);
    }

    protected abstract void addItemToMenu();

}
