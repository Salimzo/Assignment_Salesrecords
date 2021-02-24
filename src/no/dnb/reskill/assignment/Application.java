package no.dnb.reskill.assignment;

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

        String file;
        int index;

        int option = -1;
        do {

            try {
                System.out.println("Options");
                System.out.println("Menu choice 1: Number of orders by region");
                System.out.println("Menu choice 2: ");
                System.out.println("Menu choice 3");
                System.out.println("Menu choice 4");
                System.out.println("Menu choice 5");
                System.out.println("Menu choice 6");
                System.out.println("Menu choice 7");
                System.out.println("Menu choice 8");
                System.out.println("Menu choice 9");
                System.out.println("10 Quit!");
                System.out.println("----------------");

                option = helper.getInt("Choose one of the options above: ");

                switch (option) {

                    case 1:
                        System.out.println(sr.getStatisticsAsString(StatisticType.NUMBER_OF_ORDERS_BY_REGION));
                        break;

                    case 2:
                        if(false) {
                            System.out.println("");
                        }
                        break;
                    case 3:
                        if(false) {
                        System.out.println("");
                    }
                        break;
                    case 4:
                        if (false) {
                            System.out.println("");
                        }
                        break;
                    case 5:
                        if (false) {
                            System.out.println("");
                        }
                        break;
                    case 6:
                        if (false) {
                            System.out.println("");
                        }
                        break;
                    case 7: if(false) {
                        System.out.println("");
                    }
                        break;
                    case 8: if (false) {
                        System.out.println("");
                    }
                        break;
                    case 9: if(false) {
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
