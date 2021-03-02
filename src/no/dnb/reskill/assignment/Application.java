package no.dnb.reskill.assignment;

import no.dnb.reskill.assignment.statistics.StatisticType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class Application {
    private final UI helper;
    private final SalesRegistry sr = new SalesRegistry();

    public Application (UI helper) {
        this.helper = helper;
    }

    public String getFileNameFromUser() {
        return helper.getString("Enter CSV.file name");
    }

    public int getAndValidateOptionFromUser() {
        System.out.println("------------------------------------------");
        System.out.println("| Queen & Kings menu:");
        System.out.println("| 1: Number of orders by region");
        System.out.println("| 2: Regional key numbers");
        System.out.println("| 3: Number of orders by country");
        System.out.println("| 4: Country key numbers");
        System.out.println("| 5: Item key numbers");
        System.out.println("| 6: Write to file");
        System.out.println("| 7: Quit program");
        System.out.println("------------------------------------------");

        try {
            int option = helper.getInt("Choose one of the options above: ");
            if (option<1 || option>7) {
                System.out.println("Sorry, enter a number between 1 and 7.\n");
                return -10;
            }
            return option;
        } catch (NumberFormatException e ) {
            System.out.println("Sorry, enter an integer.");

        } catch (InputMismatchException e2) {
            System.out.println("Sorry, enter an integer.");
        }
        return 7;
    }



    public void start() {
        SalesReaderCsv fileReader;
        try {
            fileReader = new SalesReaderCsv(sr, getFileNameFromUser());
            System.out.printf("Number of Lines read: %d\n", fileReader.getLineCount());
            menu();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file, sorry pal.");
        } catch (IOException e) {
            System.out.println("Can't read file, sorry pal.");
        }
    }


    public void menu() {
        int option = -1;
        do {
            try {
                option = getAndValidateOptionFromUser();
                switch (option) {

                    case 1:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
                        break;
                    case 2:
                        System.out.println(sr.getStatisticsAsString(StatisticType.REGIONAL_KEY_NUMBERS));
                        break;
                    case 3:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_COUNTRY));
                        break;
                    case 4:
                        System.out.println(sr.getStatisticsAsString(StatisticType.COUNTRY_KEY_NUMBERS));
                        break;
                    case 5:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_ITEMTYPE));
                        break;
                    case 6:
                        exportFileFromMenu();
                        break;
                    case 0:
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("Wrong input.\n%s\n%s\n", e.getMessage(), e.getCause());
            }
        } while (option != 7);
    }


    private void exportFileFromMenu() {
        String data = sr.getStatisticsAsString(StatisticType.GLOBAL_KEY_NUMBERS);
        try {
            String filename = SaveSummary.saveToFile(data);
            System.out.printf("I have stored the global key numbers to file %s%n", filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
