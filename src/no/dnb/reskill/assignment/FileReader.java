package no.dnb.reskill.assignment;

import java.io.BufferedReader;
import java.io.IOException;

public interface FileReader {

    //public SalesRegistry readFile(String fileName);

    public boolean openFile(String fileName) throws IOException;

}
