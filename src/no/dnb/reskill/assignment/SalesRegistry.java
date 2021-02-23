package no.dnb.reskill.assignment;

import java.util.ArrayList;


public class SalesRegistry {
    private ArrayList<Sale> allSales = new ArrayList<>();


    /**
     * This method converts from a array of Strings to a Sale object
     * @param csvLineValues String array with each sale variable represented as array value
     * @return Sale object
     */
    public static Sale createSaleFromCSVLine(String[] csvLineValues) {
        //TODO: Flytte til SalesReaderCSV (Marina?)
        Sale s = new Sale();
        s.setRegion(            csvLineValues[0]);
        s.setCountry(           csvLineValues[1]);
        s.setItemType(          csvLineValues[2]);
        s.setSalesChannel(      csvLineValues[3]);
        s.setOrderPriority(     csvLineValues[4]);
        s.setOrderDate(         csvLineValues[5]);
        s.setOrderId(           Long.parseLong(csvLineValues[6]));
        s.setShipDate(          csvLineValues[7]);
        s.setUnitsSold(         Integer.parseInt(csvLineValues[8]));
        s.setUnitPrice(         Double.parseDouble(csvLineValues[9]));
        s.setUnitCost(          Double.parseDouble(csvLineValues[10]));
        s.setTotalRevenue(      Double.parseDouble(csvLineValues[11]));
        s.setTotalCost(         Double.parseDouble(csvLineValues[12]));
        s.setTotalProfit(       Double.parseDouble(csvLineValues[13]));
        return s;
    }


    /**
     * Adds a Sale object to the array list containing all sales.
     * @param sale
     * @return true (as specified by ArrayList.add)
     */
    public boolean addSale(Sale sale) {
        this.indexSale(sale);
        return allSales.add(sale);
    }


    /**
     * Indexes sales by different key values, to optimize search
     * @param sale
     */
    private void indexSale(Sale sale) {
        //TODO: Implement this function
    }



}
