package no.dnb.reskill.assignment;



import java.util.Scanner;

public class Main implements Usable {

    SalesRegistry sr = new SalesRegistry();
    //Ta i mote filnavn og sende over til Marina sin FileReader

    

    public static void main(String[] args) {

        System.out.println("Enter CSV.file name");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // kanskje vi skal ha en annen lese-inn klasse? Ikke Scanner altså?

    }
}
