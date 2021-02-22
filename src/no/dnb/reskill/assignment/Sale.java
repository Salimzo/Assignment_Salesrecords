package no.dnb.reskill.assignment;

import lombok.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private String region;
    private String country;
    private String itemType;
    private String salesChannel; //TODO enum?
    private String orderPriority; //TODO enum?
    private LocalDate orderDate;
    private long orderId;
    private LocalDate shipDate;
    private int unitsSold;
    private double unitPrice;
    private double unitCost;
    private double totalRevenue;
    private double totalCost;
    private double totalProfit;


    public void setOrderDate(int day, int month, int year) throws DateTimeException {
        this.orderDate = LocalDate.of(year, month, day);
    }

    public void setOrderDate(String orderDate) throws DateTimeException {
        this.orderDate = LocalDate.parse(orderDate);
    }

    public void setShipDate(int day, int month, int year) throws DateTimeException {
        this.shipDate = LocalDate.of(year, month, day);
    }

    public void setShipDate(String orderDate) throws DateTimeException {
        this.shipDate = LocalDate.parse(orderDate);
    }

}





