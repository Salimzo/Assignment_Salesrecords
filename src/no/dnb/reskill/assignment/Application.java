package no.dnb.reskill.assignment;

import java.util.Scanner;

public class Application implements Usable {

    private SalesRegistry sr = new SalesRegistry();
    //Ta i mote filnavn og sende over til Marina sin FileReader

    public void start () {

        System.out.println("Enter CSV.file name");
        Scanner scanner = new Scanner(System.in);


        // kanskje vi skal ha en annen lese-inn klasse? Ikke Scanner altså?
        String filename = scanner.nextLine();
        SalesReaderCsv filereader = new SalesReaderCsv(sr, filename);



    }
}
