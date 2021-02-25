package no.dnb.reskill.assignment.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticDouble extends Statistic {
    private double value;

    public StatisticDouble(StatisticValue statisticValue, StatisticGroup groupBy) {
        super(statisticValue, groupBy);
    }

    public void add(long valueToAdd) {}
    public void add(double valueToAdd) {
        value += valueToAdd;
    }
    public double getDoubleValue() {
        return value;
    }
    public long getIntValue() { return 0; }


    @Override
    public String toString() {
        return String.format("%s: %s", getDescription(), getText());
    }




}
