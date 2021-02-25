package no.dnb.reskill.assignment;

import java.io.*;
import java.text.ParseException;

public class SalesReaderCsv implements FileReaderWriter {

    SalesRegistry sales;
    BufferedReader br;
    private int lineCount;

    public SalesReaderCsv(SalesRegistry sales, String fileName) throws FileNotFoundException, IOException {
        this.sales = sales;
        openFile(fileName);
        lineCount = readFile();
    }

    @Override
    public boolean openFile(String fileName) throws FileNotFoundException{
            this.br = new BufferedReader(new FileReader(fileName));
            return true;
    }

    public int getLineCount() {
        return lineCount;
    }

    @Override
     public int readFile() throws IOException {
        br.readLine();
        try {
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                try {
                    Sale sale = createSaleFromCSVLine(line);
                    sales.addSale(sale);
                    lineCount++;
                } catch (ParseException e) {}
            }
            return lineCount;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public boolean writeFile(String newFileName) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFileName)));
        return false;
    }

    /**
     * This method converts from a array of Strings to a Sale object
     * @param line is a String with each sale split by ","
     * @return Sale object
     */
    public static Sale createSaleFromCSVLine(String line) throws ParseException{
        try {
            String[] csvLineValues = line.split(",");
            if (csvLineValues.length != 14) {
                throw new ParseException("Something is wrong with the data file.", -1);
            }
            Sale s = new Sale();
            s.setRegion(csvLineValues[0]);
            s.setCountry(csvLineValues[1]);
            s.setItemType(csvLineValues[2]);
            s.setSalesChannel(csvLineValues[3]);
            s.setOrderPriority(csvLineValues[4]);
            s.setOrderDate(csvLineValues[5]);
            s.setOrderId(Long.parseLong(csvLineValues[6]));
            s.setShipDate(csvLineValues[7]);
            s.setUnitsSold(Integer.parseInt(csvLineValues[8]));
            s.setUnitPrice(Double.parseDouble(csvLineValues[9]));
            s.setUnitCost(Double.parseDouble(csvLineValues[10]));
            s.setTotalRevenue(Double.parseDouble(csvLineValues[11]));
            s.setTotalCost(Double.parseDouble(csvLineValues[12]));
            s.setTotalProfit(Double.parseDouble(csvLineValues[13]));
            return s;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }
}
