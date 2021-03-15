package fileManagement.fileProcessing;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DocOpenFile extends BasicOpenFile {

    public DocOpenFile(String path) throws IOException {
        super(path);
    }

    @Override
    public String readFile() throws IOException {
        WordExtractor extractor;

        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filePath));
        HWPFDocument doc = new HWPFDocument(buffer);
        extractor = new WordExtractor(doc);

        buffer.close();

        return extractor.getText();
    }
}
