package appagency.dao;

import appagency.model.User;
import appagency.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.math.BigInteger;

@Component
public class ProfileDAOImpl implements ProfileDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_USER = "select * from users where user_id = ?";

    @Autowired
    public ProfileDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserById(BigInteger id) {
        return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] {id}, new UserMapper());
    }
}
