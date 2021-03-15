package ui.JMenus.MenuItems;

import ui.AppInterface;

import javax.swing.*;
import java.awt.*;

public abstract class BasicJMenuItem extends JMenuItem {

    protected JMenu parentMenu;
    protected String name;
    protected JMenuItem menuItem;
    protected Font itemFont;
    protected AppInterface app;

    public BasicJMenuItem(JMenu parentMenu, String name) {
        this.app = app;
        this.parentMenu = parentMenu;
        this.name = name;
        initializeFields();
        createJMenuItem();
    }

    private void initializeFields() {
        itemFont = new Font("Cambria", Font.PLAIN, 13);
    }

    protected void createJMenuItem() {
        menuItem = new JMenuItem(name);
        customizeMenuItem();
        addItemToJMenu();
    }

    private void customizeMenuItem() {
        menuItem.setFont(itemFont);
    }

    protected void addItemToJMenu() {
        parentMenu.add(menuItem);
    }

    public AppInterface getAppInterface() {
        return app;
    }

    protected abstract void addListener();
}
