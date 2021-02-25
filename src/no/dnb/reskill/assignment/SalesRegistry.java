package no.dnb.reskill.assignment;


import no.dnb.reskill.assignment.statistics.StatisticGroup;
import no.dnb.reskill.assignment.statistics.StatisticRegistry;
import no.dnb.reskill.assignment.statistics.StatisticType;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class SalesRegistry {
    private final ArrayList<Sale> allSales = new ArrayList<>();
    private final TreeMap<String, ArrayList<Sale>> regions = new TreeMap<>();
    private final TreeMap<String, ArrayList<Sale>> countries = new TreeMap<>();
    private final TreeMap<String, ArrayList<Sale>> itemTypes = new TreeMap<>();
    private final ArrayList<String> stringList = new ArrayList<>();


    /**
     * Adds a Sale object to the array list containing all sales.
     * @param sale A fully implemented Sale object
     * @return true (as specified by ArrayList.add)
     */
    public boolean addSale(Sale sale) {
        this.indexSale(sale);
        return allSales.add(sale);
    }

    private void indexSale(Sale sale) {
        addSaleToIndex(regions, sale.getRegion(), sale);
        addSaleToIndex(countries, sale.getCountry(), sale);
        addSaleToIndex(itemTypes, sale.getItemType(), sale);
    }

    private void addSaleToIndex(TreeMap<String, ArrayList<Sale>> treeMap, String key, Sale sale) {
        if (!treeMap.containsKey(key)) {
            treeMap.put(key, new ArrayList<>());
        }
        treeMap.get(key).add(sale);
    }

    /**
     *
     * @return List of all Sale objects stored in SalesRegistry
     */
    public List<Sale> getSales() {
        return allSales;
    }

    public List<Sale> getSalesByRegion(String region) {
        return regions.get(region);
    }

    public List<Sale> getSalesByCountry(String country) {
        return countries.get(country);
    }

    public List<Sale> getSalesByItemType(String itemType) {
        return itemTypes.get(itemType);
    }




    public String getStatisticsAsString(StatisticType type) {
        List<String> statistics = getStatisticsAsArray(type);
        StringBuilder sb = new StringBuilder();
        for ( String s : statistics ) {
            sb.append(String.format("%s %n", s));
        }
        return sb.toString();
    }


    private List<String> getStatisticsAsArray(StatisticType type) {
        switch (type) {
            case NUMBER_OF_ORDERS_BY_REGION:
                countSalesIndexContent(regions);
                break;

            case NUMBER_OF_ORDERS_BY_COUNTRY:
                countSalesIndexContent(countries);
                break;

            case NUMBER_OF_ORDERS_BY_ITEMTYPE:
                countSalesIndexContent(itemTypes);
                break;

            case REGIONAL_KEY_NUMBERS:
                analyzeKeyNumbersFromSalesIndex(regions, StatisticGroup.REGION);
                break;

            case COUNTRY_KEY_NUMBERS:
                analyzeKeyNumbersFromSalesIndex(countries, StatisticGroup.COUNTRY);
                break;

            case GLOBAL_KEY_NUMBERS:
                analyzeKeyNumbersFromArrayList(allSales, StatisticGroup.GLOBAL, "Global key numbers");
                break;

            default:
                stringList.add("No valid selection. No statistic return");
        }
        return stringList;
    }



    private void countSalesIndexContent(TreeMap<String,ArrayList<Sale>> map) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<Sale> sales = entry.getValue();
            stringList.add(String.format("%s: %d orders", key, sales.size()));
        }
    }


    private void analyzeKeyNumbersFromSalesIndex(TreeMap<String,ArrayList<Sale>> map, StatisticGroup statisticGroup) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            String title = String.format("Key numbers for %s:", entry.getKey());
            analyzeKeyNumbersFromArrayList(entry.getValue(), statisticGroup, title);
        }
    }


    private void analyzeKeyNumbersFromArrayList(ArrayList<Sale> sales, StatisticGroup statisticGroup, String title) {
        StatisticRegistry statisticRegistry = new StatisticRegistry(statisticGroup);
        stringList.add(String.format("%n------------ %s", title));
        stringList.addAll(statisticRegistry.createStatisticsFromSales(sales));
    }


}
