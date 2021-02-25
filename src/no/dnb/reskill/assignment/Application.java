package no.dnb.reskill.assignment;

import no.dnb.reskill.assignment.statistics.StatisticType;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application implements Usable {

    private UI helper = new Helper();
    private SalesRegistry sr = new SalesRegistry();

    public String getFileNameFromUser() {
        return "SalesRecords.csv";
//        return helper.getString("Enter CSV.file name");
    }

    public void start() {
        try {
            SalesReaderCsv fileReader = new SalesReaderCsv(sr, getFileNameFromUser());
            System.out.println(fileReader.getLineCount());
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
                System.out.println("Options");
                System.out.println("Menu choice 1: Number of orders by region");
                System.out.println("Menu choice 2: Regional key numbers");
                System.out.println("Menu choice 3: Country key numbers");
                System.out.println("Menu choice 4: Summary information");
                System.out.println("Menu choice 5: Item key numbers");
                System.out.println("6 Quit!");
                System.out.println("------------------------------------------");

                option = helper.getInt("Choose one of the options above: ");

                switch (option) {

                    case 1:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
                        break;
                    case 2:
                        System.out.println(sr.getStatisticsAsString(StatisticType.REGIONAL_KEY_NUMBERS) );
                        break;
                    case 3:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_COUNTRY));
                        break;
                    case 4:
                        System.out.println(sr.getStatisticsAsString(StatisticType.COUNTRY_KEY_NUMBERS) );
                        //System.out.println(sr.getStatisticsAsString(StatisticType.XXXXXXXXXXXXX));
                        break;
                    case 5:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_ITEMTYPE));
                        break;
                }
            } catch (Exception e) {
                System.out.printf("Wrong input.\n%s\n%s\n", e.getMessage(), e.getCause());
            }
        } while (option != 6);
    }

}
