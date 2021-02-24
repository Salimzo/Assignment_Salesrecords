package no.dnb.reskill.assignment;

import java.util.Collection;

public interface UI {

    public String getString(String promptMsg);

    public double getDouble(String promptMsg);

    public int getInt(String promptMsg);

    public <T> void displayCollection(Collection<T> list);

}
