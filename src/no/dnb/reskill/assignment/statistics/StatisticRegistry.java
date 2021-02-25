package no.dnb.reskill.assignment.statistics;

import no.dnb.reskill.assignment.Sale;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class StatisticRegistry {
    private final StatisticGroup groupBy;
    private final LinkedHashMap<StatisticValue, Statistic> statisticStorage;


    public StatisticRegistry(StatisticGroup groupBy) {
        this.groupBy = groupBy;
        statisticStorage = new LinkedHashMap<>();
        statisticStorage.put(StatisticValue.TOTAL_COUNT, null);
        statisticStorage.put(StatisticValue.OVERALL_PROFIT, null);
        statisticStorage.put(StatisticValue.MOST_PROFITABLE, null);
        statisticStorage.put(StatisticValue.LEAST_PROFITABLE, null);
        statisticStorage.put(StatisticValue.AVERAGE_PROFIT, null);
        statisticStorage.put(StatisticValue.TOTAL_UNITS_SOLD, null);
        statisticStorage.put(StatisticValue.MOST_UNITS_SOLD, null);
        statisticStorage.put(StatisticValue.LEAST_UNITS_SOLD, null);

    }


    public List<String> createStatisticsFromSales(List<Sale> sales) {
        for (Sale sale : sales) {
            analyzeSale(sale);
        }

        int count = sales.size();
        StatisticInt totalCount = new StatisticInt(StatisticValue.TOTAL_COUNT, this.groupBy);
        totalCount.setValue(count);
        statisticStorage.put(StatisticValue.TOTAL_COUNT, totalCount);

        double total = statisticStorage.get(StatisticValue.OVERALL_PROFIT).getDoubleValue();
        double avr = total / count;
        StatisticDouble sd = new StatisticDouble(StatisticValue.AVERAGE_PROFIT, this.groupBy );
        sd.setValue(avr);
        statisticStorage.put(StatisticValue.AVERAGE_PROFIT, sd);

        return getStatistics();
    }


    private List<String> getStatistics() {
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<StatisticValue, Statistic> entry : statisticStorage.entrySet()) {
            Statistic statistic = entry.getValue();
            if (statistic != null) {
                list.add(statistic.toString());
            }
        }
        return list;
    }


    private void analyzeSale(Sale sale) {
        for (Map.Entry<StatisticValue, Statistic> entry : statisticStorage.entrySet()) {
            switch (entry.getKey()) {
                case OVERALL_PROFIT:
                    summarizeOverallProfit(entry, sale);
                    break;
                case MOST_PROFITABLE:
                    compareMostProfitable(entry, sale);
                    break;

                case LEAST_PROFITABLE:
                    compareLeastProfitable(entry, sale);
                    break;

                case TOTAL_UNITS_SOLD:
                    summarizeTotalUnitsSold(entry, sale);
                    break;

                case MOST_UNITS_SOLD:
                    compareMostUnitsSold(entry, sale);
                    break;

                case LEAST_UNITS_SOLD:
                    compareLeastUnitsSold(entry, sale);
                    break;
                default:

            }
        }
    }

    private void summarizeOverallProfit(Map.Entry<StatisticValue, Statistic> entry, Sale sale) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

        if (value == null) {
            entry.setValue(new StatisticDouble(key, this.groupBy));
        }
        entry.getValue().add(sale.getTotalProfit());

    }

    private void compareMostProfitable(Map.Entry<StatisticValue, Statistic> entry, Sale sale) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

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
    }

    private void compareLeastProfitable(Map.Entry<StatisticValue, Statistic> entry, Sale sale) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

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
    }

    private void summarizeTotalUnitsSold(Map.Entry<StatisticValue, Statistic> entry, Sale sale) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

        if (value == null) {
            entry.setValue(new StatisticInt(key, this.groupBy));
        }
        entry.getValue().add(sale.getUnitsSold());
    }

    private void compareMostUnitsSold(Map.Entry<StatisticValue, Statistic> entry, Sale sale) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

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
    }

    private void compareLeastUnitsSold(Map.Entry<StatisticValue, Statistic> entry, Sale sale ) {
        StatisticValue key = entry.getKey();
        Statistic value = entry.getValue();

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
    }

}
