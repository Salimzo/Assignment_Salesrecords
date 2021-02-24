package no.dnb.reskill.assignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistic {
    String description;
    Sale sale;

    public Statistic(String description) {
        this.description = description;
    }


}
