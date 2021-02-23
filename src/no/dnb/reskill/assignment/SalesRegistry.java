package no.dnb.reskill.assignment;


import java.util.ArrayList;
import java.util.TreeMap;


public class SalesRegistry {
    private ArrayList<Sale> allSales = new ArrayList<>();
    private TreeMap<String, ArrayList<Sale>> regions = new TreeMap<>();
    private TreeMap<String, ArrayList<Sale>> countries = new TreeMap<>();
    private TreeMap<String, ArrayList<Sale>> itemTypes = new TreeMap<>();



    /**
     * Adds a Sale object to the array list containing all sales.
     * @param sale
     * @return true (as specified by ArrayList.add)
     */
    public boolean addSale(Sale sale) {
        this.indexSale(sale);
        return allSales.add(sale);
    }

    public ArrayList getSales() {
        return allSales;
    }

    public ArrayList getSales_byRegion(String region) {
        return regions.get(region);
    }

    public ArrayList getSales_byCountry(String country) {
        return countries.get(country);
    }

    public ArrayList getSales_byItemType(String itemType) {
        return itemTypes.get(itemType);
    }



    private void indexSale(Sale sale) {
        updateTreeMap(regions, sale.getRegion(), sale);
        updateTreeMap(countries, sale.getCountry(), sale);
        updateTreeMap(itemTypes, sale.getItemType(), sale);
    }

    private void updateTreeMap(TreeMap<String, ArrayList<Sale>> treeMap, String key, Sale sale) {
        if (!treeMap.containsKey(key)) {
            treeMap.put(key, new ArrayList<>());
        }
        treeMap.get(key).add(sale);
    }



}
