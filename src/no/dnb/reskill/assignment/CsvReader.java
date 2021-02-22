package no.dnb.reskill.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvReader implements FileReader {

    SalesRegistry sales = new SalesRegistry();

    @Override
    public SalesRegistry readFile(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            br.readLine();
            String line1 = null;
            while ((line1 = br.readLine()) != null) {

                String[] attributes = line1.split(",");
                Sale sale = SalesRegistry.createSaleFromCSVLine(attributes);
                sales.addSale(sale);
                line1 = br.readLine(); //read next line before looping, if end of file reached, line would be null


            }
        } catch (IOException e) {
            e.printStackTrace();      //prints the throwable along line number and class name where the exception occurred
        }
        return sales;
    }



}
