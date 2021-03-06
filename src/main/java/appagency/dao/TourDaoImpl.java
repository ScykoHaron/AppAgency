package appagency.dao;

import appagency.model.Tour;
import appagency.model.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class TourDaoImpl implements TourDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TourDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SQL_GET_ALL_TOUR = "select * from tours where count_limit > 0 and start_date > sysdate order by location";
    private final String SQL_INCREASE_COUNT_TOUR = "update tours set count_limit = count_limit + 1 where tour_id = ?";
    private final String SQL_DECREASE_COUNT_TOUR = "update tours set count_limit = count_limit - 1 where tour_id = ?";

    @Override
    public List<Tour> getTours() {
        return jdbcTemplate.query(SQL_GET_ALL_TOUR, new TourMapper());
    }

    @Override
    public void increaseCount(BigInteger tourId) {
        jdbcTemplate.update(SQL_INCREASE_COUNT_TOUR, tourId);
    }

    @Override
    public void decreaseCount(BigInteger tourId) {
        jdbcTemplate.update(SQL_DECREASE_COUNT_TOUR, tourId);
    }
}
