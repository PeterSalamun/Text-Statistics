package fileManagement.fileProcessing;

import java.io.IOException;
import java.util.ArrayList;

public abstract class BasicOpenFile {


    protected String filePath;


    public BasicOpenFile(String path) throws IOException {
        this.filePath = path;
    }

    //TODO dorobit vynimky
    public abstract String readFile() throws IOException;
}
