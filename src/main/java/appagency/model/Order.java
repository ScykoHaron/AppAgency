package appagency.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class Order {
    private BigInteger orderId;
    private BigInteger userId;
    private BigInteger tourId;
    private boolean confirmed;
    private LocalDate timeKey;

    public Order(){

    }

    public Order(BigInteger orderId, BigInteger userId, BigInteger tourId, boolean confirmed, LocalDate timeKey) {
        this.orderId = orderId;
        this.userId = userId;
        this.tourId = tourId;
        this.confirmed = confirmed;
        this.timeKey = timeKey;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getTourId() {
        return tourId;
    }

    public void setTourId(BigInteger tourId) {
        this.tourId = tourId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public LocalDate getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(LocalDate timeKey) {
        this.timeKey = timeKey;
    }
}
