package no.dnb.reskill.assignment;

import java.util.Scanner;
import java.util.Collection;

public class Helper implements UI {

    // Create a Scanner object, to get keyboard input.
    private Scanner scanner = new Scanner(System.in);

    // Get a String from the user.
    public String getString(String promptMsg) {
        System.out.printf("%s", promptMsg);
        return scanner.next();
    }

    // Get a double from the user.
    public double getDouble(String promptMsg) {
        System.out.printf("%s", promptMsg);
        return scanner.nextDouble();
    }

    // Get an int from the user.
    public int getInt(String promptMsg) {
        System.out.printf("%s", promptMsg);
        return scanner.nextInt();
    }

    // Generic method, displays all the items in a Collection<T>.
    public <T> void displayCollection(Collection<T> list) {
        System.out.printf("Elements in %s:\n", list.getClass().getName());
        for (T element : list) {
            System.out.printf("  %s value: %s.\n", element.getClass().getName(), element);
        }
    }

}
