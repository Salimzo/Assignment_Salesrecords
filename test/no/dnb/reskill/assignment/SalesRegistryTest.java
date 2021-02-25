package no.dnb.reskill.assignment;

import no.dnb.reskill.assignment.statistics.StatisticType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SalesRegistryTest {
    private SalesRegistry fixture;

    @Before
    public void setup() {
        fixture = new SalesRegistry();
    }


    @Test
    public void salesRegistry_addSale_shouldReturnTrueOnSuccess() {
        Sale s = new Sale();
        s.setRegion("Middle East and North Africa");
        s.setCountry("Libya");
        s.setItemType("Cosmetics");

        assertTrue(fixture.addSale(s));
    }

    @Test
    public void salesRegistry_addingOneSale_shouldReturnArraysOfSize1() {
        // Arrange
        Sale sale = new Sale();
        sale.setRegion("Middle East and North Africa");
        sale.setCountry("Libya");
        sale.setItemType("Cosmetics");

        // Act
        fixture.addSale(sale);

        // Assert
        boolean actual = fixture.getSales().size() == 1
                && fixture.getSales_byRegion("Middle East and North Africa").size() == 1
                && fixture.getSales_byCountry("Libya").size() == 1
                && fixture.getSales_byItemType("Cosmetics").size() == 1;
        assertTrue(actual);
    }

    @Test
    public void salesRegistry_addingTwoSalesFromSameRegion_shouldReturnArraysOfDifferentSize() {
        // Arrange
        Sale s1 = new Sale();
        s1.setRegion("Middle East and North Africa");
        s1.setCountry("Libya");
        s1.setItemType("Cosmetics");
        Sale s2 = new Sale();
        s2.setRegion("Middle East and North Africa");
        s2.setCountry("Algeria");
        s2.setItemType("Personal Care");

        // Act
        fixture.addSale(s1);
        fixture.addSale(s2);

        // Assert
        boolean actual = fixture.getSales().size() == 2
                && fixture.getSales_byRegion("Middle East and North Africa").size() == 2
                && fixture.getSales_byCountry("Libya").size() == 1
                && fixture.getSales_byCountry("Algeria").size() == 1
                && fixture.getSales_byItemType("Cosmetics").size() == 1
                && fixture.getSales_byItemType("Personal Care").size() == 1;
        assertTrue(actual);
    }


    @Test
    public void salesRegistry_getStatisticsAfterAddingTwoOrders_shouldReturnStatistics() {
        // Arrange
        Sale s1 = new Sale();
        s1.setRegion("Middle East and North Africa");
        s1.setCountry("Libya");
        s1.setItemType("Cosmetics");
        Sale s2 = new Sale();
        s2.setRegion("Middle East and North Africa");
        s2.setCountry("Algeria");
        s2.setItemType("Personal Care");

        // Act
        fixture.addSale(s1);
        fixture.addSale(s2);

        // Assert
        System.out.println(fixture.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
        assertTrue(false);
    }




    //Middle East and North Africa,Libya,Cosmetics,Offline,M,10/18/2014,686800706,10/31/2014,8446,437.20,263.33,3692591.20,2224085.18,1468506.02

}