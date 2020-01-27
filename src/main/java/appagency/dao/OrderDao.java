package appagency.dao;

import appagency.model.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDao {
    List<Order> getOrders(BigInteger userId);

    void deleteOrder(BigInteger orderId);

    void addOrder(BigInteger userId, BigInteger tourId);
}
