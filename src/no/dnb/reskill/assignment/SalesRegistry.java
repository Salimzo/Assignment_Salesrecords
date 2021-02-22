package no.dnb.reskill.assignment;

import java.util.ArrayList;

public class SalesRegistry {
    private ArrayList<Sale> sales = new ArrayList<>();


    public static Sale createSaleFromCSVLine(String[] csvLineValues) {
        Sale s = new Sale();
        //TODO: Implement logic to parse from string values from CSV to Sale-attributes
        return s;
    }


}
