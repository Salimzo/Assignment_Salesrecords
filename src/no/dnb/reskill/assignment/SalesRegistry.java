package no.dnb.reskill.assignment;


import no.dnb.reskill.assignment.statistics.StatisticGroup;
import no.dnb.reskill.assignment.statistics.StatisticRegistry;
import no.dnb.reskill.assignment.statistics.StatisticType;



import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;





public class SalesRegistry {
    private ArrayList<Sale> allSales = new ArrayList<>();
    private TreeMap<String, ArrayList<Sale>> regions = new TreeMap<>();
    private TreeMap<String, ArrayList<Sale>> countries = new TreeMap<>();
    private TreeMap<String, ArrayList<Sale>> itemTypes = new TreeMap<>();
    private StatisticRegistry statisticRegistry;

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




    public String getStatisticsAsString(StatisticType type) {
        ArrayList<String> statistics = getStatistics(type);
        StringBuilder sb = new StringBuilder();
        for ( String s : statistics ) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public ArrayList getStatistics(StatisticType type) {
        ArrayList<String> statistics = new ArrayList<>();

        switch (type) {
            case NUMBER_OF_ORDERS_BY_REGION:
                countSizeOfTreeMapValues(statistics, regions);
                break;

            case NUMBER_OF_ORDERS_BY_COUNTRY:
                countSizeOfTreeMapValues(statistics, countries);
                break;

            case NUMBER_OF_ORDERS_BY_ITEMTYPE:
                countSizeOfTreeMapValues(statistics, itemTypes);
                break;

            case REGIONAL_KEY_NUMBERS:
                extractKeyNumbersFromMapValues(statistics, regions, StatisticGroup.REGION);
                break;

            case COUNTRY_KEY_NUMBERS:
                extractKeyNumbersFromMapValues(statistics, countries, StatisticGroup.COUNTRY);

            default:
                statistics.add("No valid selection. No statistic return");
        }
        return statistics;
    }





    private void countSizeOfTreeMapValues(ArrayList<String> statistics, TreeMap<String,ArrayList<Sale>> map) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<Sale> sales = entry.getValue();
            statistics.add(String.format("%s: %d orders", key, sales.size()));
        }
    }


    private void extractKeyNumbersFromMapValues(ArrayList<String> statistics, TreeMap<String,ArrayList<Sale>> map, StatisticGroup statisticGroup) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            statisticRegistry = new StatisticRegistry(statisticGroup);

            String key = entry.getKey();
            ArrayList<Sale> sales = entry.getValue();
            statistics.add(String.format("\n------------ Key numbers for %s:", key));
            statisticRegistry.evaluateSales(sales);
            for (String s : statisticRegistry.getStatistics()) {
                statistics.add(s);
            }
        }
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
