package fileManagement.fileProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TXTOpenFile extends BasicOpenFile {

    public TXTOpenFile(String path) throws IOException {
        super(path);
    }

    @Override
    public String readFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();

        return builder.toString();
    }
}
