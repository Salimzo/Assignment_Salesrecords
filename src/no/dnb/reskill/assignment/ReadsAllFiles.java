package no.dnb.reskill.assignment;

import java.io.IOException;

public interface ReadsAllFiles {

    public int readFile() throws IOException;

    public boolean openFile(String fileName) throws IOException;


}
