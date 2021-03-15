package ui.JMenus.MenuItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitJMenuItem extends BasicJMenuItem {

    public ExitJMenuItem(JMenu parentMenu, String name) {
        super(parentMenu, name);
        addListener();
    }

    @Override
    protected void addListener() {
        menuItem.addActionListener(new ExitJMenuItemClickHandler());
    }

    private class ExitJMenuItemClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
