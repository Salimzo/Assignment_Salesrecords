package no.dnb.reskill.assignment;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.*;

public class Application implements Usable {

    private Helper helper = new Helper();

    private SalesRegistry sr = new SalesRegistry();
    //Ta i mote filnavn og sende over til Marina sin FileReader

    public void start () {

        String filename = helper.getString("Enter CSV.file name");

        // kanskje vi skal ha en annen lese-inn klasse? Ikke Scanner altså?

        SalesReaderCsv filereader = new SalesReaderCsv(sr);
        try {
            if(filereader.openFile(filename)) {
                filereader.readFile();
                menu();

            }

        } catch (IOException e) {
            System.out.println("Can't find file, sorry pal.");
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
                System.out.println("----------------");

                option = helper.getInt("Choose one of the options above: ");

                switch (option) {

                    case 1:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
                        break;

                    case 2:

                        System.out.println(sr.getStatisticsAsString(StatisticType.XXXXXXXXXXXXX));

                        break;
                    case 3:

                           System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_COUNTRY));;

                        break;
                    case 4:

                            System.out.println(sr.getStatisticsAsString(StatisticType.XXXXXXXXXXXXX));

                        break;
                    case 5:

                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_ITEMTYPE));

                        break;
                }
            } catch (Exception e) {

            }
        } while (option != 6);
    }

}
