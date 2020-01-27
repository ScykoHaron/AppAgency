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
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@Import(JdbcConfig.class)
@Sql("/data.sql")
public class ProfileDaoImplTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    ProfileDao profileDao;




    @Before
    public void setUp(){
        profileDao = new ProfileDaoImpl(jdbcTemplate,new BCryptPasswordEncoder());
    }

    @Test
    public void getUserByLogin() {
        User user = profileDao.getUserByLogin("VP@mail");
        Assert.assertEquals("Vasya",user.getFirstName());
        Assert.assertEquals("Pupkin",user.getLastName());
        Assert.assertEquals("VP@mail",user.getEmail());
        Assert.assertEquals("$2a$10$AvVEW4wYqxCi8rfJBr4c8e2CCSejb/.4J51RqkkvienhptrtLXzWa",user.getPassword());
        Assert.assertTrue(user.isActive());
        Assert.assertEquals(LocalDate.parse("1983-10-24"),user.getBirthday());
        Assert.assertEquals("ROLE_USER",user.getRole());

        User user2 = profileDao.getUserByLogin("VP2@mail");
        Assert.assertNull(user2);
    }

    @Test
    public void createUser() {
        UserForm userForm = new UserForm("S","SY","SS@mail","147","2020-10-15");
        profileDao.createUser(userForm);
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
        profileDao.updateUser(userForm);
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
        profileDao.deleteUser("VP@mail");
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
        profileDao.editUser("birthday","2020-10-20","VP@mail");
        profileDao.editUser("password","159","VP@mail");
        profileDao.editUser("first_name","S","VP@mail");
        profileDao.editUser("last_name","SY","VP@mail");
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