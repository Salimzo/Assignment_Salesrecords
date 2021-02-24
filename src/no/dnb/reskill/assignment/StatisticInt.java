package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticInt extends Statistic {
    int statisticValue;

    public StatisticInt(String description) {
        super(description);
    }

    public void add(int valueToAdd) {
        this.statisticValue += valueToAdd;
    }
}
