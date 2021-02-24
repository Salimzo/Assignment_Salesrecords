package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSalesReaderCsv {

    SalesRegistry salesRegistry;
    SalesReaderCsv salesReaderCsv;
    SalesReaderCsv readerOneLine;
    SalesReaderCsv readerTenLines;
    SalesReaderCsv readerEmptyFile;


    @Before
    public void setup() throws IOException {
        salesRegistry = new SalesRegistry();
        salesReaderCsv = new SalesReaderCsv(salesRegistry, "SalesRecords.csv");

        //readerOneLine = new SalesReaderCsv(salesRegistry, "FileOneLine.rtf");
        //readerTenLines = new SalesReaderCsv(salesRegistry, "FileTenLines.rtf");
        //readerEmptyFile = new SalesReaderCsv(salesRegistry, "EmptyFile.rtf");
    }

    @Test (expected = FileNotFoundException.class)
    public void openFile_notExistingFile_throwsException() throws FileNotFoundException {
        salesReaderCsv.openFile("NotExistingFile.csv");
    }

    @Test
    public void openFile_existingFile_returnTrue() throws FileNotFoundException {
        assertTrue(salesReaderCsv.openFile("SalesRecords.csv"));
    }

    @Test
    public void readFile_readsFromSecondRow_correct() {
        //TODO
    }


    @Test
    public void creatingSale_fromCSVLine_shouldReturnSaleObject() {
        String[] csvValues = {"1","2", "3"};
        Sale s = salesReaderCsv.createSaleFromCSVLine(csvValues);
        assertTrue(s instanceof Sale);
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnAValidSaleObject() {
        // TODO: Should be improved
        String csvLine = "Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02";
        String[] csvValues = csvLine.split(",");
        Sale s = salesReaderCsv.createSaleFromCSVLine(csvValues);
        double expectedTotalProfit = 1468506.02;
        assertEquals(expectedTotalProfit, s.getTotalProfit(), 0);
    }

}
