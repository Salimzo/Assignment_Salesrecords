package no.dnb.reskill.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SalesReaderCsv implements FileReader {

    SalesRegistry sales;
    String fileName;

    public SalesReaderCsv(SalesRegistry sales, String fileName) {
        this.sales = sales;
        this.fileName = fileName;
    }

    @Override
    public BufferedReader openFile(String fileName) throws IOException {
        Path pathToFile = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
        return br;
    }

    @Override
    public SalesRegistry readFile(String fileName) {
        try (BufferedReader br = openFile(fileName)) {
            br.readLine();
            String line1;
            while ((line1 = br.readLine()) != null) {

                String[] attributes = line1.split(",");
                Sale sale = createSaleFromCSVLine(attributes);
                sales.addSale(sale);
                line1 = br.readLine(); //read next line before looping, if end of file reached, line would be null


            }
        } catch (IOException e) {
            e.printStackTrace();      //prints the throwable along line number and class name where the exception occurred
        }
        return sales;
    }

    /**
     * This method converts from a array of Strings to a Sale object
     * @param csvLineValues String array with each sale variable represented as array value
     * @return Sale object
     */
    public static Sale createSaleFromCSVLine(String[] csvLineValues) {
        Sale s = new Sale();
        s.setRegion(            csvLineValues[0]);
        s.setCountry(           csvLineValues[1]);
        s.setItemType(          csvLineValues[2]);
        s.setSalesChannel(      csvLineValues[3]);
        s.setOrderPriority(     csvLineValues[4]);
        s.setOrderDate(         csvLineValues[5]);
        s.setOrderId(           Long.parseLong(csvLineValues[6]));
        s.setShipDate(          csvLineValues[7]);
        s.setUnitsSold(         Integer.parseInt(csvLineValues[8]));
        s.setUnitPrice(         Double.parseDouble(csvLineValues[9]));
        s.setUnitCost(          Double.parseDouble(csvLineValues[10]));
        s.setTotalRevenue(      Double.parseDouble(csvLineValues[11]));
        s.setTotalCost(         Double.parseDouble(csvLineValues[12]));
        s.setTotalProfit(       Double.parseDouble(csvLineValues[13]));
        return s;
    }
}
