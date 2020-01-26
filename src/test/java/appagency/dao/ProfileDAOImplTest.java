package appagency.dao;

import appagency.config.JdbcConfig;
import appagency.form.UserForm;
import appagency.model.User;
import appagency.model.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import(JdbcConfig.class)
@Sql("/data.sql")
public class ProfileDAOImplTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    ProfileDAO profileDAO;




    @Before
    public void setUp(){
        profileDAO = new ProfileDAOImpl(jdbcTemplate,new BCryptPasswordEncoder());
    }

    @Test
    public void getUserByLogin() {
        User user = profileDAO.getUserByLogin("VP@mail");
        Assert.assertEquals("Vasya",user.getFirstName());
        Assert.assertEquals("Pupkin",user.getLastName());
        Assert.assertEquals("VP@mail",user.getEmail());
        Assert.assertEquals("$2a$10$AvVEW4wYqxCi8rfJBr4c8e2CCSejb/.4J51RqkkvienhptrtLXzWa",user.getPassword());
        Assert.assertTrue(user.isActive());
        Assert.assertEquals(LocalDate.parse("1983-10-24"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());

        User user2 = profileDAO.getUserByLogin("VP2@mail");
        Assert.assertNull(user2);
    }

    @Test
    public void createUser() {
        UserForm userForm = new UserForm("S","SY","SS@mail","147","2020-10-15");
        profileDAO.createUser(userForm);
        User user = jdbcTemplate.queryForObject("select * from users where email = 'SS@mail'", new UserMapper());
        Assert.assertEquals("S",user.getFirstName());
        Assert.assertEquals("SY",user.getLastName());
        Assert.assertEquals("SS@mail",user.getEmail());
        Assert.assertTrue(new BCryptPasswordEncoder().matches("147", user.getPassword()));
        Assert.assertTrue(user.isActive());
        Assert.assertEquals(LocalDate.parse("2020-10-15"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());
    }

    @Test
    public void updateUser() {
        UserForm userForm = new UserForm("S","SY","OL@mail","159","2020-10-15");
        profileDAO.updateUser(userForm);
        User user = jdbcTemplate.queryForObject("select * from users where email = 'OL@mail'", new UserMapper());
        Assert.assertEquals("S",user.getFirstName());
        Assert.assertEquals("SY",user.getLastName());
        Assert.assertEquals("OL@mail",user.getEmail());
        Assert.assertTrue(new BCryptPasswordEncoder().matches("159", user.getPassword()));
        Assert.assertTrue(user.isActive());
        Assert.assertEquals(LocalDate.parse("2020-10-15"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());
    }

    @Test
    public void deleteUser() {
        profileDAO.deleteUser("VP@mail");
        User user = jdbcTemplate.queryForObject("select * from users where email = 'VP@mail'", new UserMapper());
        Assert.assertEquals("Vasya",user.getFirstName());
        Assert.assertEquals("Pupkin",user.getLastName());
        Assert.assertEquals("VP@mail",user.getEmail());
        Assert.assertEquals("$2a$10$AvVEW4wYqxCi8rfJBr4c8e2CCSejb/.4J51RqkkvienhptrtLXzWa",user.getPassword());
        Assert.assertFalse(user.isActive());
        Assert.assertEquals(LocalDate.parse("1983-10-24"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());
    }

    @Test
    public void editUser() {
        profileDAO.editUser("birthday","2020-10-20","VP@mail");
        profileDAO.editUser("password","159","VP@mail");
        profileDAO.editUser("first_name","S","VP@mail");
        profileDAO.editUser("last_name","SY","VP@mail");
        User user = jdbcTemplate.queryForObject("select * from users where email = 'VP@mail'", new UserMapper());
        Assert.assertEquals("S",user.getFirstName());
        Assert.assertEquals("SY",user.getLastName());
        Assert.assertEquals("VP@mail",user.getEmail());
        Assert.assertTrue(new BCryptPasswordEncoder().matches("159", user.getPassword()));
        Assert.assertTrue(user.isActive());
        Assert.assertEquals(LocalDate.parse("2020-10-20"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());


    }
}