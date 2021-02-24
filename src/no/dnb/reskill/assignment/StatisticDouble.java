package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticDouble extends Statistic {
    private double statisticValue;

    public StatisticDouble(String description) {
        super(description);
    }

    public void add(int valueToAdd) {};
    public void add(double valueToAdd) {
        this.statisticValue += valueToAdd;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", description, statisticValue);
    }

}
