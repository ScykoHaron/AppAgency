package appagency.dao;

import appagency.model.Order;
import appagency.model.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SQL_GET_USER_ORDER = "SELECT q.order_id, w.tour_id, NAME ,DESCRIPTION ,LOCATION ,START_DATE ,END_DATE ,time_key FROM ORDERS q join tours w on q.tour_id = w.tour_id and q.user_id = ? order by order_id";
    private final String SQL_DELETE_ORDER = "delete from orders where order_id = ?";
    private final String SQL_ADD_ORDER = "insert into orders(user_id, tour_id, confirmed, time_key) values(?, ?, ?, ?)";

    @Override
    public List<Order> getOrders(BigInteger id) {
        return jdbcTemplate.query(SQL_GET_USER_ORDER, new OrderMapper(), id);
    }

    @Override
    public void deleteOrder(BigInteger id) {
        jdbcTemplate.update(SQL_DELETE_ORDER, id);
    }

    @Override
    public void addOrder(BigInteger userId, BigInteger tourId) {
        jdbcTemplate.update(SQL_ADD_ORDER, userId, tourId, true, LocalDate.now());
    }
}
