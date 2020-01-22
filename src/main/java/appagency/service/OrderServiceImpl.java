package appagency.service;

import appagency.dao.OrderDAOImpl;
import appagency.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAOImpl orderDAO;

    @Override
    public List<Order> getOrder(BigInteger id) {
        return orderDAO.getOrders(id);
    }
}
