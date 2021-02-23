package no.dnb.reskill.assignment;

import java.util.ArrayList;


public class SalesRegistry {
    private ArrayList<Sale> allSales = new ArrayList<>();


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
