package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Statistic {
    String description;
    Sale sale;

    public Statistic(String description) {
        this.description = description;
    }

    public abstract void add(double value);

    public abstract void add(int value);

}
