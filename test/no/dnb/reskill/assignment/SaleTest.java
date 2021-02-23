package no.dnb.reskill.assignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleTest {
    Sale s;

    @Before
    public void setup() {
        s = new Sale();
    }



    @Test
    public void onSaleObject_settingOrderDate_shouldSaveDateCorrect() {
        s.setOrderDate(12,9,2013 );
        String expected = "2013-09-12";
        String actual = s.getOrderDate().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void onSaleObject_settingShipDate_shouldSaveDateCorrect() {
        s.setShipDate(14, 9, 2012);
        String expected = "2012-09-14";
        String actual = s.getShipDate().toString();
        assertEquals(expected, actual);
    }



}