package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

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
        readerOneLine = new SalesReaderCsv(salesRegistry, "FileOneLine.csv");
        assertThat(readerOneLine.getLineCount(), equalTo(1));
    }

    @Test
    public void readFile_readsFileTneLines_counterNine() throws IOException {
        readerTenLines = new SalesReaderCsv(salesRegistry, "FileTenLines.csv");
        assertThat(readerTenLines.getLineCount(), equalTo(9));
    }

    @Test
    public void readFile_readsEmptyFile_countZero() throws IOException {
        readerEmptyFile = new SalesReaderCsv(salesRegistry, "EmptyFile.csv");
        assertThat(readerEmptyFile.getLineCount(), equalTo(0));
    }

    @Test
    public void createSaleFromCSVLine_oneLineFromCSV_shouldReturnSalesObject() throws ParseException{
        String salesRecordLine = "Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02";
        Sale s = salesReaderCsv.createSaleFromCSVLine(salesRecordLine);
        assertTrue(s instanceof Sale);
    }

    @Test (expected = ParseException.class)
    public void createSaleFromCSVLine_oneLineFromCSV_shouldReturnNull() throws ParseException {
        String salesRecordLine = "Middle East and North Africa:Libya:Cosmetics:Offline:M:10/18/2014:686800706:10/31/2014:8446:437.20:263.33:3692591.20:2224085.18:1468506.02";
        Sale s = salesReaderCsv.createSaleFromCSVLine(salesRecordLine);
        }
}

