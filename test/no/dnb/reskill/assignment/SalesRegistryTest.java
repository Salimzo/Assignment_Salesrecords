package no.dnb.reskill.assignment;

import no.dnb.reskill.assignment.SalesRegistry;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalesRegistryTest {
    @Test
    public void creatingSale_fromCSVLine_shouldReturnSaleObject() {
        String[] csvValues = {"1","2", "3"};
        Sale s = SalesRegistry.createSaleFromCSVLine(csvValues);
        assertTrue(s instanceof Sale);
    }

}