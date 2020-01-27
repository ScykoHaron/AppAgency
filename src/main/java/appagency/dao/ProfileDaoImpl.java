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
public class ProfileDaoImpl implements ProfileDao {

    JdbcTemplate jdbcTemplate;
    PasswordEncoder passwordEncoder;

    @Autowired
    public ProfileDaoImpl(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }


    private final String SQL_FIND_USER = "select * from users where email = ?";
    private final String SQL_INSERT_USER = "insert into users(first_name, last_name, email, password, active, birthday,role) values(?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE_USER = "update users set first_name = ?, last_name = ?, email = ?, password = ?, active = ?, birthday = ?, role = ? where email = ?";
    private final String SQL_DELETE_USER = "update users set active = false where email = ?";

    @Override
    public User getUserByLogin(String login) {
        List<User> users = jdbcTemplate.query(SQL_FIND_USER, new Object[]{login}, new UserMapper());
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void createUser(UserForm userForm) {
        jdbcTemplate.update(SQL_INSERT_USER, userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), passwordEncoder.encode(userForm.getPassword()), true, LocalDate.parse(userForm.getBirthday()), "ROLE_USER");
    }

    @Override
    public void updateUser(UserForm userForm) {
        jdbcTemplate.update(SQL_UPDATE_USER, userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), passwordEncoder.encode(userForm.getPassword()), true, LocalDate.parse(userForm.getBirthday()), "ROLE_USER", userForm.getEmail());
    }

    @Override
    public void deleteUser(String login) {
        jdbcTemplate.update(SQL_DELETE_USER, login);
    }

    @Override
    public void editUser(String field, String value, String login) {
        String sql = "update users set " + field + " = ? where email = '" + login + "'";
        if (field.equals("birthday")) {
            jdbcTemplate.update(sql, LocalDate.parse(value));
        } else if (field.equals("password")) {
            jdbcTemplate.update(sql, passwordEncoder.encode(value));
        } else {
            jdbcTemplate.update(sql, value);
        }

    }
}
