package appagency.dao;

import appagency.form.UserForm;
import appagency.model.User;
import appagency.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final String SQL_FIND_USER = "select * from users where email = ?";
    private final String SQL_INSERT_USER = "insert into users(first_name, last_name, email, password, active, birthday,role) values(?, ?, ?, ?, ?, ?, ?)";


    @Override
    public User getUserByLogin(String login) {
        List<User> users = jdbcTemplate.query(SQL_FIND_USER, new Object[] {login}, new UserMapper());
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void createUser(UserForm userForm) {
        jdbcTemplate.update(SQL_INSERT_USER, userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), passwordEncoder.encode(userForm.getPassword())  , true, LocalDate.parse(userForm.getBirthday()), "ROLE_USER");
    }

}
