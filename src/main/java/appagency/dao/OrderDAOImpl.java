package appagency.dao;

import appagency.model.Order;
import appagency.model.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_USER_ORDER  = "SELECT q.order_id, NAME ,DESCRIPTION ,LOCATION ,START_DATE ,END_DATE ,time_key FROM ORDERS q join tours w on q.tour_id = w.tour_id and q.user_id = ? order by order_id";

    @Override
    public List<Order> getOrders(BigInteger id) {
        return jdbcTemplate.query(SQL_GET_USER_ORDER, new OrderMapper(), id);
    }
}