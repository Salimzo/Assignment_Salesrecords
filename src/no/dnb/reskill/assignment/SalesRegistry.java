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
    private final ArrayList<String> statisticsCollection = new ArrayList<>();


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
                countSizeOfTreeMapValues(regions);
                break;

            case NUMBER_OF_ORDERS_BY_COUNTRY:
                countSizeOfTreeMapValues(countries);
                break;

            case NUMBER_OF_ORDERS_BY_ITEMTYPE:
                countSizeOfTreeMapValues(itemTypes);
                break;

            case GLOBAL_KEY_NUMBERS:
                testingSomething(StatisticGroup.GLOBAL, "Global key numbers", allSales);
                break;

            case REGIONAL_KEY_NUMBERS:
                extractKeyNumbersFromMapValues(regions, StatisticGroup.REGION);
                break;

            case COUNTRY_KEY_NUMBERS:
                extractKeyNumbersFromMapValues(countries, StatisticGroup.COUNTRY);
                break;

            default:
                statisticsCollection.add("No valid selection. No statistic return");
        }
        return statisticsCollection;
    }





    private void countSizeOfTreeMapValues(TreeMap<String,ArrayList<Sale>> map) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<Sale> sales = entry.getValue();
            statisticsCollection.add(String.format("%s: %d orders", key, sales.size()));
        }
    }


    private void extractKeyNumbersFromMapValues(TreeMap<String,ArrayList<Sale>> map, StatisticGroup statisticGroup) {
        for(Map.Entry<String,ArrayList<Sale>> entry : map.entrySet()) {
            String title = String.format("Key numbers for %s:", entry.getKey());
            testingSomething(statisticGroup, title, entry.getValue());
        }
    }

    private void testingSomething(StatisticGroup statisticGroup, String statisticTitle, ArrayList<Sale> sales) {
        StatisticRegistry statisticRegistry = new StatisticRegistry(statisticGroup);
        statisticsCollection.add(String.format("%n------------ %s", statisticTitle));
        statisticsCollection.addAll(statisticRegistry.createStatisticsFromSales(sales));
    }







}
