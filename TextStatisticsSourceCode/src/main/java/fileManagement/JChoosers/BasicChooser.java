package fileManagement.JChoosers;


import Exceptions.FileNotFoundExceptionCall;
import Exceptions.NoFileChooseExceptionCall;
import Exceptions.WrongExtensionExceptionCall;

import javax.swing.*;

public abstract class BasicChooser extends JFrame {

    protected JFileChooser chooser;
    protected String title;
    protected String filterMess;
    protected String filePath;

    //Constructor
    public BasicChooser(String title, String filterMess) throws WrongExtensionExceptionCall, NoFileChooseExceptionCall, FileNotFoundExceptionCall {
        this.title = title;
        this.filterMess = filterMess;
        initChooser();
    }

    //EFFECTS: abstract definition of a methods
    protected abstract void initChooser() throws WrongExtensionExceptionCall, NoFileChooseExceptionCall, FileNotFoundExceptionCall;

    protected abstract void customizeChooser();

    //getters
    public String getFilePath() {return filePath;}

}
