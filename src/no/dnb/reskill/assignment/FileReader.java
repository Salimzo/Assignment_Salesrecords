package no.dnb.reskill.assignment;

import java.io.IOException;

public interface FileReader {

    public int readFile() throws IOException;

    public boolean writeFile(String newFileName) throws IOException;

    public boolean openFile(String fileName) throws IOException;

}
