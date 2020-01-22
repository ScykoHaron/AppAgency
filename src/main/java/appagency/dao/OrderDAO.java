package appagency.dao;

import appagency.model.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDAO {
    List<Order> getOrders(BigInteger id);
}
