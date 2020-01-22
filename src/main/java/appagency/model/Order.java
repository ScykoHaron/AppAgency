package appagency.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class Order {
    private BigInteger orderId;
    private String name;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate timeKey;

    public Order(){

    }

    public Order(BigInteger orderId, String name, String description, String location, LocalDate startDate, LocalDate endDate, LocalDate timeKey) {
        this.orderId = orderId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeKey = timeKey;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(LocalDate timeKey) {
        this.timeKey = timeKey;
    }
}
