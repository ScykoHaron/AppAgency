package appagency.model;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrderId(BigInteger.valueOf(resultSet.getLong("order_id")));
        order.setUserId(BigInteger.valueOf(resultSet.getLong("user_id")));
        order.setTourId(BigInteger.valueOf(resultSet.getLong("tour_id")));
        order.setConfirmed(resultSet.getBoolean("confirmed"));
        order.setTimeKey(LocalDate.parse(resultSet.getString("time_key")));
        return order;
    }
}
