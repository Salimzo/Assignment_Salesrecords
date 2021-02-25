package no.dnb.reskill.assignment.statistics;

import lombok.Getter;
import lombok.Setter;
import no.dnb.reskill.assignment.Sale;


@Getter
@Setter
public abstract class Statistic {
    protected StatisticValue statisticValue;
    protected Sale sale;
    protected StatisticGroup groupBy;


    protected Statistic(StatisticValue statisticValue, StatisticGroup groupBy) {
        this.statisticValue = statisticValue;
        this.groupBy = groupBy;
    }


    public abstract void add(double value);
    public abstract void add(long value);
    public abstract double getDoubleValue();
    public abstract long getIntValue();


    protected String getText() {
        switch (this.groupBy) {
            case REGION:
                switch (this.statisticValue) {
                    case OVERALL_PROFIT:
                    case AVERAGE_PROFIT:
                        return String.format("%1$,.2f", getDoubleValue());
                    case MOST_PROFITABLE:
                    case LEAST_PROFITABLE:
                        return String.format("%s (%.2f)",sale.getCountry(), sale.getTotalProfit());
                    case TOTAL_UNITS_SOLD:
                    case TOTAL_COUNT:
                        return String.format("%d", getIntValue());
                    case MOST_UNITS_SOLD:
                    case LEAST_UNITS_SOLD:
                        return String.format("%s (%d)",sale.getCountry(), sale.getUnitsSold());
                    default:
                        return "";
                }

            case COUNTRY:
                switch (this.statisticValue) {
                    case OVERALL_PROFIT:
                    case AVERAGE_PROFIT:
                        return String.format("%1$,.2f", getDoubleValue());
                    case MOST_PROFITABLE:
                    case LEAST_PROFITABLE:
                        return String.format("%s (%.2f)",sale.getItemType(), sale.getTotalProfit());
                    case TOTAL_UNITS_SOLD:
                    case TOTAL_COUNT:
                        return String.format("%d", getIntValue());
                    case MOST_UNITS_SOLD:
                    case LEAST_UNITS_SOLD:
                        return String.format("%s (%d)",sale.getItemType(), sale.getUnitsSold());
                    default:
                        return sale.getCountry();
                }

            case ITEM_TYPE:
                return sale.getItemType();
            default:
                return "";
        }
    }

    protected String getDescription() {
        switch (this.statisticValue) {
            case TOTAL_COUNT:
                switch (this.groupBy) {
                    case COUNTRY:
                        return "Total number of item types";
                    case REGION:
                        return "Total number of countries";
                    default:
                        return "Total count";
                }

            case OVERALL_PROFIT:
                return "Overall profit";
            case MOST_PROFITABLE:
                return "Most profitable";
            case LEAST_PROFITABLE:
                return "Least profitable";
            case AVERAGE_PROFIT:
                return "Average profit";
            case TOTAL_UNITS_SOLD:
                return "Total units sold";
            case MOST_UNITS_SOLD:
                return "Most units sold";
            case LEAST_UNITS_SOLD:
                return "Least units sold";
            default:
                return "";
        }
    }




}
