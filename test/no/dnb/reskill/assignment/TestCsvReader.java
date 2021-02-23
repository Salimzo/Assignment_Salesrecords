package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TestCsvReader {

    @Mock
    SalesReaderCsv mockCsvReader;

    @InjectMocks
    SalesRegistry fixture;

    @Before
    public void setup() {
        //TODO
        mockCsvReader = new SalesReaderCsv(fixture = new SalesRegistry());
    }

    @Test
    public void openFile() {
        try {
      //      when(mockCsvReader.openFile("SalesRecords.csv")).thenReturn(true);
            mockCsvReader.openFile("SalesRecords.csv");
        } catch (IOException e) {
            assertTrue(false);
        }

    }

    @Test
    public void readFile_readsFromSecondRow_correct() {
        //TODO
    }

    @Test (expected = IOException.class)
    public void readFile_notExistingFile_throwsException() {
  //      mockCsvReader.readFile("Not_existing_file");
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnSaleObject() {
        String[] csvValues = {"1","2", "3"};
        Sale s = mockCsvReader.createSaleFromCSVLine(csvValues);
        assertTrue(s instanceof Sale);
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnAValidSaleObject() {
        // TODO: Should be improved
        String csvLine = "Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02";
        String[] csvValues = csvLine.split(",");
        Sale s = mockCsvReader.createSaleFromCSVLine(csvValues);
        double expectedTotalProfit = 1468506.02;
        assertEquals(expectedTotalProfit, s.getTotalProfit(), 0);
    }





}
