package appagency.dao;

import appagency.form.UserForm;
import appagency.model.User;
import appagency.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;

@Component
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_USER = "select * from users where user_id = ?";
    private final String SQL_INSERT_USER = "insert into users(first_name, last_name, email, password, active, birthday) values(?, ?, ?, ?, ?, ?)";


    @Override
    public User getUserById(BigInteger id) {
       return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] {id}, new UserMapper());

    }

    @Override
    public void createUser(UserForm userForm) {
        jdbcTemplate.update(SQL_INSERT_USER, userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), userForm.getPassword(), true, LocalDate.parse(userForm.getBirthday()));
    }
}
