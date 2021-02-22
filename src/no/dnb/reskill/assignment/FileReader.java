package no.dnb.reskill.assignment;

import java.util.List;

public interface FileReader {

    //BufferedReader provides buffering of data for fast reading
    public List<Sale> readFile(String fileName);

    //Open
    //Close

}
