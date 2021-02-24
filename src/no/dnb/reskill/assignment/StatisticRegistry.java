package no.dnb.reskill.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class StatisticRegistry {
    private StatisticGroup groupBy;
    private HashMap<StatisticValue, Statistic> statisticStorage;

    public StatisticRegistry(StatisticGroup groupBy) {
        this.groupBy = groupBy;
        statisticStorage = new HashMap<>();
        statisticStorage.put(StatisticValue.OVERALL_PROFIT, null);
        statisticStorage.put(StatisticValue.MOST_PROFITABLE, null);
        statisticStorage.put(StatisticValue.LEAST_PROFITABLE, null);
        statisticStorage.put(StatisticValue.TOTAL_UNITS_SOLD, null);
        statisticStorage.put(StatisticValue.MOST_UNITS_SOLD, null);
        statisticStorage.put(StatisticValue.LEAST_UNITS_SOLD, null);
    }

    public void evaluateSale(Sale sale) {
        for (Map.Entry<StatisticValue, Statistic> entry : statisticStorage.entrySet()) {
            StatisticValue key = entry.getKey();
            Statistic value = entry.getValue();

            switch (key) {
                case OVERALL_PROFIT:
                    if (value == null) {
                        entry.setValue(new StatisticDouble(key, this.groupBy));
                    }
                    entry.getValue().add(sale.getTotalProfit());
                    break;
                case MOST_PROFITABLE:
                    if (value == null) {
                        StatisticDouble sd = new StatisticDouble(key, this.groupBy );
                        sd.setSale(sale);
                        entry.setValue(sd);
                    }
                    else {
                        if (sale.getTotalProfit() > value.getSale().getTotalProfit()) {
                            entry.getValue().setSale(sale);
                        }
                    }
                    break;

                case LEAST_PROFITABLE:
                    if (value == null) {
                        StatisticDouble sd = new StatisticDouble(key, this.groupBy );
                        sd.setSale(sale);
                        entry.setValue(sd);
                    }
                    else {
                        if (sale.getTotalProfit() < value.getSale().getTotalProfit()) {
                            entry.getValue().setSale(sale);
                        }
                    }
                    break;

                case TOTAL_UNITS_SOLD:
                    if (value == null) {
                        entry.setValue(new StatisticInt(key, this.groupBy));
                    }
                    entry.getValue().add(sale.getUnitsSold());
                    break;

                case MOST_UNITS_SOLD:
                    if (value == null) {
                        StatisticInt si = new StatisticInt(key, this.groupBy );
                        si.setSale(sale);
                        entry.setValue(si);
                    }
                    else {
                        if (sale.getUnitsSold() > value.getSale().getUnitsSold()) {
                            entry.getValue().setSale(sale);
                        }
                    }
                    break;

                case LEAST_UNITS_SOLD:
                    if (value == null) {
                        StatisticInt si = new StatisticInt(key, this.groupBy );
                        si.setSale(sale);
                        entry.setValue(si);
                    }
                    else {
                        if (sale.getUnitsSold() < value.getSale().getUnitsSold()) {
                            entry.getValue().setSale(sale);
                        }
                    }
                    break;
            }
        }
    }



    public ArrayList<String> getStatistics() {
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<StatisticValue, Statistic> entry : statisticStorage.entrySet()) {
            Statistic statistic = entry.getValue();
            if (statistic != null) {
                list.add(statistic.toString());
            }
        }

        return list;
    }





}
