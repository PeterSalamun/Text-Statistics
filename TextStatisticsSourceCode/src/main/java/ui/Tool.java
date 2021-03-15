package ui;

import javax.swing.*;
import java.awt.*;

public abstract class Tool {

    protected AppInterface app;
    private JComponent parent;
    protected String name;

    GridBagConstraints grid;

    public Tool() {
    }

    public Tool(AppInterface app, JComponent parent, String name, int column, int line, int height, int width,
                int[] insets) {
        this.app = app;
        this.parent = parent;
        this.name = name;
        initializeConstraints(column, line, height, width, insets);

    }

    protected void addChildToParent(JComponent parent, JComponent child) {
        parent.add(child, this.grid);
    }

    private void initializeConstraints(int gridY, int gridX, int componentHeight, int componentWidth,
                                       int[] insets) {
        grid = new GridBagConstraints();
        grid.gridx = gridX;
        grid.gridy = gridY;
        grid.gridheight = componentHeight;
        grid.gridwidth = componentWidth;
        grid.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);
        grid.anchor = GridBagConstraints.WEST;
    }

    protected abstract void addListener();

    public JComponent getParent() {return parent;}

    public String getName() {return name;}

    public AppInterface getApp() {
        return app;
    }
}
