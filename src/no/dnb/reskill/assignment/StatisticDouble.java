package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticDouble extends Statistic {
    double statisticValue;

    public StatisticDouble(String description) {
        super(description);
    }

    public void add(double valueToAdd) {
        this.statisticValue += valueToAdd;
    }

}
