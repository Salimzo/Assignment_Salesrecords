package no.dnb.reskill.assignment;

import java.io.IOException;
import java.util.*;

public class Application implements Usable {

    private SalesRegistry sr = new SalesRegistry();
    //Ta i mote filnavn og sende over til Marina sin FileReader

    public void start () {

        System.out.println("Enter CSV.file name");
        Scanner scanner = new Scanner(System.in);


        // kanskje vi skal ha en annen lese-inn klasse? Ikke Scanner altså?
        String filename = scanner.nextLine();
        SalesReaderCsv filereader = new SalesReaderCsv(sr);
        try {
            if(filereader.openFile("SalesRecords.csv")) {
                filereader.readFile();
                System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
            }

        } catch (IOException e) {
            System.out.println("Can't find file, sorry pal.");
        }


    }

    public static void name() {

        String file;
        int index;

        int option = -1;
        do {
            try {
                System.out.println("Options");
                System.out.println("Menu choice 1");
                System.out.println("Menu choice 2");
                System.out.println("Menu choice 3");
                System.out.println("Menu choice 4");
                System.out.println("Menu choice 5");
                System.out.println("Menu choice 6");
                System.out.println("Menu choice 7");
                System.out.println("Menu choice 8");
                System.out.println("Menu choice 9");
                System.out.println("10 Quit!");

                switch (option) {

                    case 1:
                        if() {
                        System.out.println("");
                    }
                        break;
                        if() {
                            System.out.println("");
                        }
                    case 2:
                        if() {
                            System.out.println("");
                        }
                        break;
                    case 3:
                        if() {
                        System.out.println("");
                    }
                        break;
                    case 4:
                        if () {
                            System.out.println("");
                        }
                        break;
                    case 5:
                        if () {
                            System.out.println("");
                        }
                        break;
                    case 6:
                        if () {
                            System.out.println("");
                        }
                        break;
                    case 7: if() {
                        System.out.println("");
                    }
                        break;
                    case 8: if () {
                        System.out.println("");
                    }
                        break;
                    case 9: if() {
                        System.out.println();
                    }
                        break;
                    default:


                }
            } catch (Exception e) {

            }
        } while (option != 10);
    }

}
