package appagency.service;

import appagency.model.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {
    List<Order> getOrder(BigInteger userId);

    void delOrder(BigInteger orderId);

    void addOrder(BigInteger userId, BigInteger tourId);
}
