package appagency.service;

import appagency.dao.OrderDAO;
import appagency.dao.OrderDAOImpl;
import appagency.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public List<Order> getOrder(BigInteger id) {
        return orderDAO.getOrders(id);
    }

    @Override
    public void delOrder(BigInteger id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    public void addOrder(BigInteger userId, BigInteger tourId) {
        orderDAO.addOrder(userId, tourId);
    }
}
