package appagency.service;

import appagency.dao.OrderDao;
import appagency.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getOrder(BigInteger userId) {
        return orderDao.getOrders(userId);
    }

    @Override
    public void delOrder(BigInteger orderId) {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public void addOrder(BigInteger userId, BigInteger tourId) {
        orderDao.addOrder(userId, tourId);
    }
}
