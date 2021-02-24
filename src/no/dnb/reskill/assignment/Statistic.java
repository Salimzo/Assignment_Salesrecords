package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

enum StatisticGroup {
    REGION,
    COUNTRY,
    ITEM_TYPE
}

enum StatisticValue {
    OVERALL_PROFIT,
    MOST_PROFITABLE,
    LEAST_PROFITABLE,
    TOTAL_UNITS_SOLD,
    MOST_UNITS_SOLD,
    LEAST_UNITS_SOLD
}



@Getter
@Setter
public abstract class Statistic {
    protected StatisticValue statisticValue;
    protected Sale sale;
    protected StatisticGroup groupBy;


    public Statistic(StatisticValue statisticValue, StatisticGroup groupBy) {
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
                        return String.format("%1$,.2f", getDoubleValue());
                    case MOST_PROFITABLE:
                    case LEAST_PROFITABLE:
                        return String.format("%s (%.2f)",sale.getCountry(), sale.getTotalProfit());
                    case TOTAL_UNITS_SOLD:
                        return String.format("%d", getIntValue());
                    case MOST_UNITS_SOLD:
                    case LEAST_UNITS_SOLD:
                        return String.format("%s (%d)",sale.getCountry(), sale.getUnitsSold());
                    default:
                        return "";
                }

            case COUNTRY:
                return sale.getCountry();
            case ITEM_TYPE:
                return sale.getItemType();
            default:
                return "";
        }
    }

    protected String getDescription() {
        switch (this.statisticValue) {
            case OVERALL_PROFIT:
                return "Overall profit";
            case MOST_PROFITABLE:
                return "Most profitable";
            case LEAST_PROFITABLE:
                return "Least profitable";
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
