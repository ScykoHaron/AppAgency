package appagency.model;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TourMapper implements RowMapper<Tour> {
    @Override
    public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setTourId(BigInteger.valueOf(resultSet.getLong("tour_id")));
        tour.setName(resultSet.getString("name"));
        tour.setDescription(resultSet.getString("description"));
        tour.setLocation(resultSet.getString("location"));
        tour.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
        tour.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
        tour.setCountLimit(resultSet.getInt("count_limit"));
        return tour;
    }
}
