package no.dnb.reskill.assignment;

import java.io.IOException;

public interface FileReader {

    public SalesRegistry readFile(String fileName) throws IOException;

}
