package fileManagement.JChoosers;

import Exceptions.FileNotFoundExceptionCall;
import Exceptions.NoFileChooseExceptionCall;
import Exceptions.WrongExtensionExceptionCall;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenChooser extends BasicChooser {

    private static final String EXT1 = "docx";
    private static final String EXT2 = "doc";
    private static final String EXT3 = "txt";
    private static final String TITLE = "Open file";
    private static final String DOCSFILES = "Microsoft Word document (docx)";
    private static final String DOCFILES = "Microsoft Word document 97-2003 (doc)";
    private static final String TXTFILES = "Common text (txt)";
    private static final String ALLFILES = "All supported files (" + EXT1 + ", "+ EXT2 + ", "+ EXT3 + ")";

    //Constuructor
    public OpenChooser() throws WrongExtensionExceptionCall, NoFileChooseExceptionCall, FileNotFoundExceptionCall {
        super(TITLE, DOCSFILES);
    }

    //MODIFIES: this
    //EFFECTS: initialize JFileChooser() chooser and calls methods customizeChooser() and chooseFilePath()
    @Override
    protected void initChooser() throws WrongExtensionExceptionCall, NoFileChooseExceptionCall, FileNotFoundExceptionCall {
        chooser = new JFileChooser();
        customizeChooser();
        chooseFilePath();
    }

    //MODIFIES: JFileChooser
    //EFFECTS: customizing JFileChosser chooser
    @Override
    protected void customizeChooser() {
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setDialogTitle(title);
        addFilters();
    }

    //EFFECTS: add filters to JChooser for supported files
    protected void addFilters() {
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(ALLFILES, EXT1, EXT2, EXT3));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(DOCSFILES, EXT1));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(DOCFILES, EXT2));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(TXTFILES, EXT3));
    }

    //EFFECTS: get file path in form of String of choose file through JFileChooser and store it in filePath field.
    // If the file does not exists it throws FileNotFoundExceptionCall,
    // if the file is of wrong type it throws WrongExtensionExceptionCall,
    // if no file will be choose through JFileChooser() it throws NoFileChooseExceptionCall
    protected void chooseFilePath() throws FileNotFoundExceptionCall, NoFileChooseExceptionCall, WrongExtensionExceptionCall {

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filePath = chooser.getSelectedFile().getAbsolutePath();
            if (!chooser.getSelectedFile().exists())
                throw new FileNotFoundExceptionCall();
        } else {
            throw new NoFileChooseExceptionCall();
        }
    }
}
