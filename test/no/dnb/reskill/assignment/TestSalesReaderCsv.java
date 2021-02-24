package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSalesReaderCsv {

    @Mock
    SalesReaderCsv mockSalesReaderCsv;

    @InjectMocks
    SalesRegistry fixture;

    @Before
    public void setup() {
        //TODO
        mockSalesReaderCsv = new SalesReaderCsv(fixture = new SalesRegistry());
    }

    @Test (expected = IOException.class)
    public void openFile_notExistingFile_throwsException() {
        try {
            mockSalesReaderCsv.openFile("Not_existing_file.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openFile() {
        try {
      //      when(mockCsvReader.openFile("SalesRecords.csv")).thenReturn(true);
            mockSalesReaderCsv.openFile("SalesRecords.csv");
        } catch (IOException e) {
            assertTrue(false);
        }
    }

    @Test
    public void readFile_readsFromSecondRow_correct() {
        //TODO
    }




    @Test
    public void creatingSale_fromCSVLine_shouldReturnSaleObject() {
        String[] csvValues = {"1","2", "3"};
        Sale s = mockSalesReaderCsv.createSaleFromCSVLine(csvValues);
        assertTrue(s instanceof Sale);
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnAValidSaleObject() {
        // TODO: Should be improved
        String csvLine = "Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02";
        String[] csvValues = csvLine.split(",");
        Sale s = mockSalesReaderCsv.createSaleFromCSVLine(csvValues);
        double expectedTotalProfit = 1468506.02;
        assertEquals(expectedTotalProfit, s.getTotalProfit(), 0);
    }

}
