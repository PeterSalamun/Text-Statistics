package ui.Buttons;

import Exceptions.FileNotFoundExceptionCall;
import Exceptions.IOExceptionCall;
import Exceptions.NoFileChooseExceptionCall;
import Exceptions.WrongExtensionExceptionCall;
import appLogicTests.TextProcessor;
import fileManagement.JChoosers.OpenChooser;
import fileManagement.fileProcessing.BasicOpenFile;
import fileManagement.fileProcessing.DocOpenFile;
import fileManagement.fileProcessing.DocXOpenFile;
import fileManagement.fileProcessing.TXTOpenFile;
import ui.AppInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartButton extends BasicButton {

    private static final String NAME = "Start";
    private static final int COLUMN = 1;
    private static final int LINE = 0;
    private static final int HEIGHT = 1;
    private static final int WIDTH = 1;
    private static final int[] INSETS = new int[]{15, 12, 10, 23};

    public StartButton(AppInterface app, JComponent parent) {
        super(app, parent, NAME, COLUMN, LINE, HEIGHT, WIDTH, INSETS);
    }

    protected void createButton() {
        button = new JButton(name);
        customizeButton();
    }

    protected void addListener() {
        button.addActionListener(new StartButtonClickHandler());
    }

    private class StartButtonClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            readAnalyzeFile();
        }

        private void readAnalyzeFile() {
            try {
                String path = openDocument();
                analyzedDocument(path);
            } catch (WrongExtensionExceptionCall e) {
                new WrongExtensionExceptionCall().getCall();
            } catch (NoFileChooseExceptionCall e) {
                new NoFileChooseExceptionCall().getCall();
            } catch (FileNotFoundExceptionCall e) {
                new FileNotFoundExceptionCall().getCall();
            } catch (IOException e) {
                new IOExceptionCall().getCall();
            }
        }

        private String openDocument() throws WrongExtensionExceptionCall, NoFileChooseExceptionCall, FileNotFoundExceptionCall {
            OpenChooser openFile = new OpenChooser();
            return openFile.getFilePath();
        }

        private void analyzedDocument(String filePath) throws WrongExtensionExceptionCall, IOException {
            String ext = filePath.substring(filePath.indexOf(".") + 1);
            BasicOpenFile openFile = null;
            if (ext.equals("docx"))
                openFile = new DocXOpenFile(filePath);
            else if (ext.equals("doc"))
                openFile = new DocOpenFile(filePath);
            else if (ext.equals("txt"))
                openFile = new TXTOpenFile(filePath);
            else {
                throw new WrongExtensionExceptionCall();
            }

            String[] disected = dissectingText(openFile);
            TextProcessor process = new TextProcessor(disected);
            app.getTextPane().fillTheTextArea(process.getTextAnalysis());
        }

        private String[] dissectingText(BasicOpenFile file) throws IOException {
            String text;
            if (file == null) {
                throw new IOException("IOEXCEPTION");
            } else {
                text = file.readFile();
                return text.split("(?<=[.!?])\\s*");
            }
        }

    }
}
