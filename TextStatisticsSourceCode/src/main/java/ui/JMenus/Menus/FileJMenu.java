package ui.JMenus.Menus;

import ui.JMenus.MenuItems.ExitJMenuItem;

import javax.swing.*;

public class FileJMenu extends BasicJMenu {

    ExitJMenuItem exitItem;

    public FileJMenu(JMenuBar parentBar, String name) {
        super(parentBar, name);
        addItemToMenu();
    }

    @Override
    protected void addItemToMenu() {
        exitItem = new ExitJMenuItem(menu, "Exit");
    }
}
