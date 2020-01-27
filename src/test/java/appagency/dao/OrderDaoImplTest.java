package appagency.dao;

import appagency.config.JdbcConfig;
import appagency.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@Import(JdbcConfig.class)
@Sql("/data.sql")
public class OrderDaoImplTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    OrderDao orderDao;

    @Before
    public void setUp(){
        orderDao = new OrderDaoImpl(jdbcTemplate);
    }


    @Test
    public void getOrders() {
        List<Order> orders = orderDao.getOrders(BigInteger.ONE);
        Assert.assertEquals(2,orders.size());
        Order order1 = orders.get(0);
        Assert.assertEquals(BigInteger.ONE,order1.getOrderId());
        Assert.assertEquals(BigInteger.ONE,order1.getTourId());
        Assert.assertEquals("Tokyo",order1.getName());
        Assert.assertEquals("Gorod",order1.getDescription());
        Assert.assertEquals("Japan",order1.getLocation());
        Assert.assertEquals(LocalDate.parse("2020-01-11"), order1.getStartDate());
        Assert.assertEquals(LocalDate.parse("2020-01-20"), order1.getEndDate());
        Assert.assertEquals(LocalDate.parse("2019-12-31"),order1.getTimeKey());
        Order order2 = orders.get(1);
        Assert.assertEquals(BigInteger.valueOf(2),order2.getOrderId());
        Assert.assertEquals(BigInteger.valueOf(2),order2.getTourId());
        Assert.assertEquals("Paris",order2.getName());
        Assert.assertEquals("Gorod",order2.getDescription());
        Assert.assertEquals("France",order2.getLocation());
        Assert.assertEquals(LocalDate.parse("2021-02-25"),order2.getStartDate());
        Assert.assertEquals(LocalDate.parse("2021-03-05"),order2.getEndDate());
        Assert.assertEquals(LocalDate.parse("2019-12-31"),order2.getTimeKey());
    }

    @Test
    public void deleteOrder() {
        orderDao.deleteOrder(BigInteger.ONE);
        Assert.assertEquals(0,(long) jdbcTemplate.queryForObject("select count(*) from orders where order_id = 1", Integer.class));
    }

    @Test
    public void addOrder() {
        orderDao.addOrder(BigInteger.valueOf(3),BigInteger.valueOf(3));
        List<Map<String, Object>> orderList = jdbcTemplate.queryForList("select * from orders where user_id = 3 and tour_id = 3");
        Assert.assertEquals(3L,orderList.get(0).get("USER_ID"));
        Assert.assertEquals(3L,orderList.get(0).get("TOUR_ID"));
        Assert.assertEquals(true,orderList.get(0).get("CONFIRMED"));
        Assert.assertEquals(Date.valueOf(LocalDate.now()), orderList.get(0).get("TIME_KEY"));
    }
}