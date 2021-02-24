package no.dnb.reskill.assignment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SalesReaderCsv implements FileReaderWriter {

    SalesRegistry sales;
    BufferedReader br;

    public SalesReaderCsv(SalesRegistry sales) {
        this.sales = sales;
    }

    @Override
    public boolean openFile(String fileName) throws IOException {
        this.br = new BufferedReader(new FileReader(fileName));
        br.readLine();
        return true;
    }

    @Override
     public int readFile() throws IOException {
        try {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                Sale sale = createSaleFromCSVLine(attributes);
                sales.addSale(sale);
                count++;
            }
            return count;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public boolean writeFile(String newFileName, String fileFormat, String... neededInformation) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFileName)));
        return false;
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
