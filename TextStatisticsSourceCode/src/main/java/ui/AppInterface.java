package ui;

import ui.Buttons.BasicButton;
import ui.Buttons.ExitButton;
import ui.Buttons.ResetButton;
import ui.Buttons.StartButton;
import ui.JMenus.Menus.FileJMenu;
import ui.Pane.MyScrollPane;
import ui.Pane.TextPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppInterface extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private ArrayList<BasicButton> buttonsArray;
    private MyScrollPane scrollPane;

    public AppInterface() {
        super("Text Statistics");
        initializeFields();
        initializeGraphics();
    }


    private void initializeFields() {
        buttonsArray = new ArrayList<>();
    }

    private void initializeGraphics() {
        this.setResizable(false);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new BorderLayout());
        this.setLookAndFeel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTools();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
        }
    }

    private void createTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridBagLayout());
        toolArea.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.add(toolArea);

        createTextArea(toolArea);
        createButtons(toolArea);
        createJMenu();

    }

    private void createButtons(JPanel toolArea) {
        StartButton start = new StartButton(this, toolArea);
        buttonsArray.add(start);

        ResetButton reset = new ResetButton(this, toolArea);
        buttonsArray.add(reset);

        ExitButton exit = new ExitButton(this, toolArea);
        buttonsArray.add(exit);

    }

    private void createTextArea(JPanel toolArea) {
        scrollPane = new MyScrollPane(this, toolArea);
    }

    private void createJMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        FileJMenu fileItem = new FileJMenu(menuBar, "File");
    }

    public TextPane getTextPane() {
        return scrollPane.getTextPane();
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public ArrayList<BasicButton> getButtonsArray() {
        return buttonsArray;
    }
}
