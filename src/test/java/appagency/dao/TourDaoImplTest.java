package appagency.dao;

import appagency.config.JdbcConfig;
import appagency.model.Tour;
import appagency.model.TourMapper;
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
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@Import(JdbcConfig.class)
@Sql("/data.sql")
public class TourDaoImplTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    TourDao tourDao;

    @Before
    public void setUp() {
        tourDao = new TourDaoImpl(jdbcTemplate);
    }

    @Test
    public void getTours() {
        List<Tour> tours = tourDao.getTours();
        Assert.assertEquals(2, tours.size());
        Tour tour1 = tours.get(0);
        Assert.assertEquals("London", tour1.getName());
        Assert.assertEquals("Gorod", tour1.getDescription());
        Assert.assertEquals("England", tour1.getLocation());
        Assert.assertEquals(LocalDate.parse("2021-01-09"), tour1.getStartDate());
        Assert.assertEquals(LocalDate.parse("2021-01-20"), tour1.getEndDate());
        Assert.assertEquals(1, tour1.getCountLimit());
        Tour tour2 = tours.get(1);
        Assert.assertEquals("Paris", tour2.getName());
        Assert.assertEquals("Gorod", tour2.getDescription());
        Assert.assertEquals("France", tour2.getLocation());
        Assert.assertEquals(LocalDate.parse("2021-02-25"), tour2.getStartDate());
        Assert.assertEquals(LocalDate.parse("2021-03-05"), tour2.getEndDate());
        Assert.assertEquals(3, tour2.getCountLimit());
    }

    @Test
    public void increaseCount() {
        tourDao.increaseCount(BigInteger.valueOf(2));
        Tour tour = jdbcTemplate.queryForObject("select * from tours where tour_id = 2", new TourMapper());
        Assert.assertEquals("Paris", tour.getName());
        Assert.assertEquals("Gorod", tour.getDescription());
        Assert.assertEquals("France", tour.getLocation());
        Assert.assertEquals(LocalDate.parse("2021-02-25"), tour.getStartDate());
        Assert.assertEquals(LocalDate.parse("2021-03-05"), tour.getEndDate());
        Assert.assertEquals(4, tour.getCountLimit());
    }

    @Test
    public void decreaseCount() {
        tourDao.decreaseCount(BigInteger.valueOf(2));
        Tour tour = jdbcTemplate.queryForObject("select * from tours where tour_id = 2", new TourMapper());
        Assert.assertEquals("Paris", tour.getName());
        Assert.assertEquals("Gorod", tour.getDescription());
        Assert.assertEquals("France", tour.getLocation());
        Assert.assertEquals(LocalDate.parse("2021-02-25"), tour.getStartDate());
        Assert.assertEquals(LocalDate.parse("2021-03-05"), tour.getEndDate());
        Assert.assertEquals(2, tour.getCountLimit());
    }
}