package appagency.dao;

import appagency.model.Tour;
import appagency.model.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TourDAOImpl implements TourDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_ALL_TOUR  = "select * from tours order by location";

    @Override
    public List<Tour> getTours() {
        return jdbcTemplate.query(SQL_GET_ALL_TOUR, new TourMapper());
    }
}
