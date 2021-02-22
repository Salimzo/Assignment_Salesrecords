package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SalesRegistryTest {
//    private SalesRegistry fixture;

    @Before
    public void setup() {
//        fixture = new SalesRegistry();
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnSaleObject() {
        String[] csvValues = {"1","2", "3"};
        Sale s = SalesRegistry.createSaleFromCSVLine(csvValues);
        assertTrue(s instanceof Sale);
    }

    @Test
    public void creatingSale_fromCSVLine_shouldReturnAValidSaleObject() {
        // TODO: Should be improved
        String csvLine = "Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02";
        String[] csvValues = csvLine.split(",");
        Sale s = SalesRegistry.createSaleFromCSVLine(csvValues);
        double expectedTotalProfit = 1468506.02;
        assertEquals(expectedTotalProfit, s.getTotalProfit(), 0);
    }

}