package fileManagement.fileProcessing;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class DocXOpenFile extends BasicOpenFile {

    public DocXOpenFile(String path) throws IOException {
        super(path);
    }

    @Override
    public String readFile() throws IOException {
        XWPFWordExtractor extractor;

        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filePath));
        XWPFDocument docX = new XWPFDocument(buffer);
        extractor = new XWPFWordExtractor(docX);

        buffer.close();

        return extractor.getText();
    }
    //TODO - treba Apache POI, Internally .docx files are organized as zipped XML-files
}
