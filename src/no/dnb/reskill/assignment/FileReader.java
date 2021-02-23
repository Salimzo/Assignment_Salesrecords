package no.dnb.reskill.assignment;

import java.io.IOException;

public interface FileReader {

    public int readFile(String fileName) throws IOException;

    public boolean openFile(String fileName) throws IOException;

}
