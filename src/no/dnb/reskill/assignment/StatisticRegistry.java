package no.dnb.reskill.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticRegistry {
    private HashMap<String, Statistic> statisticStorage = new HashMap<>();

    public StatisticRegistry() {
        statisticStorage.put("Overall profit", null);
        statisticStorage.put("Most profitable", null);
        statisticStorage.put("Least profitable", null);
        statisticStorage.put("Total units sold", null);
        statisticStorage.put("Highest amount of units sold", null);
        statisticStorage.put("Lowest amount of units sold", null);
    }

    public void evaluateSale(Sale sale) {
        for (Map.Entry<String, Statistic> entry : statisticStorage.entrySet()) {
            String key = entry.getKey();
            Statistic value = entry.getValue();

            switch (key) {
                case "Overall profit":
                    if (value == null) {
                        entry.setValue(new StatisticDouble(key));
                    }
                    entry.getValue().add(sale.getTotalProfit());
                    break;
            }

        }

    }

    public ArrayList<String> getStatistics() {
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<String, Statistic> entry : statisticStorage.entrySet()) {
            Statistic statistic = entry.getValue();
            if (statistic != null) {
                list.add(statistic.toString());
            }
        }

        return list;
    }





}
