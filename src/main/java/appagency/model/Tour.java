package appagency.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class Tour {
    private BigInteger tourId;
    private String name;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private int countLimit;

    public Tour(){

    }

    public Tour(BigInteger tourId, String name, String description, String location, LocalDate startDate, LocalDate endDate, int countLimit) {
        this.tourId = tourId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.countLimit = countLimit;
    }

    public BigInteger getTourId() {
        return tourId;
    }

    public void setTourId(BigInteger tourId) {
        this.tourId = tourId;
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

    public int getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }
}
