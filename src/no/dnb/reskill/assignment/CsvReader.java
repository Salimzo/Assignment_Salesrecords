package no.dnb.reskill.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements FileReader {

    List<Sale> sales = new ArrayList<>();

    @Override
    public List<Sale> readFile(String fileName) {
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(","); //What about first line? The titles of the columns
                Sale sale = new Sale(attributes);
                sales.add(sale);
                line = br.readLine(); //read next line before looping, if end of file reached, line would be null


            }
        } catch (IOException e) {
            e.printStackTrace(); //prints the throwable along with other details like the line number and class name where the exception occurred.
        }
        return sales;
    }



}
