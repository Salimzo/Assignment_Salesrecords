package no.dnb.reskill.assignment.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticInt extends Statistic {
    long value;

    public StatisticInt(StatisticValue statisticValue, StatisticGroup groupBy) {
        super(statisticValue, groupBy);
    }

    public void add(long valueToAdd) {
        this.value += valueToAdd;
    }
    public void add(double valueToAdd){
        // Unsupported function
    }
    public double getDoubleValue() {
        return 0;
    }
    public long getIntValue() { return value; }


    @Override
    public String toString() {
        return String.format("%s: %s", getDescription(), getText());
    }
}
