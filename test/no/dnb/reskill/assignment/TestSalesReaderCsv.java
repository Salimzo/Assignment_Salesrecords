package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TestSalesReaderCsv {

    SalesRegistry salesRegistry;
    SalesReaderCsv salesReaderCsv;

    SalesRegistry salesRegistry1;
    SalesReaderCsv readerOneLine;

    SalesRegistry salesRegistry2;
    SalesReaderCsv readerTenLines;

    SalesRegistry salesRegistry3;
    SalesReaderCsv readerEmptyFile;


    @Before
    public void setup() throws IOException {
        salesRegistry = new SalesRegistry();
        salesReaderCsv = new SalesReaderCsv(salesRegistry, "SalesRecords.csv");
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
    public void readFile_readsFileOneLine_counterOne() throws IOException {
        salesRegistry1 = new SalesRegistry();
        readerOneLine = new SalesReaderCsv(salesRegistry1, "FileOneLine.csv");
        assertThat(readerOneLine.getLineCount(), equalTo(1));
    }

    @Test
    public void readFile_readsFileTenLines_counterTen() throws IOException {
        salesRegistry2 = new SalesRegistry();
        readerTenLines = new SalesReaderCsv(salesRegistry2, "FileTenLines.csv");
        assertThat(readerTenLines.getLineCount(), equalTo(9));
    }

    @Test
    public void readFile_readsEmptyFile_countZero() throws IOException {
        salesRegistry3 = new SalesRegistry();
        readerEmptyFile = new SalesReaderCsv(salesRegistry3, "EmptyFile.csv");
        assertThat(readerEmptyFile.getLineCount(), equalTo(0));
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
