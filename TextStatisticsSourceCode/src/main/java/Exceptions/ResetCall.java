package Exceptions;

import javax.swing.*;

public class ResetCall {
    //EFFECTS: Shows JOptionPane.showConfirmDialog in case of an reset request from user, return true
    public boolean getCall() {
        JOptionPane.showConfirmDialog(null, "Do you really want to reset? Your current state will be deleted!.",
                "Application reset", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        return true;
    }
}
