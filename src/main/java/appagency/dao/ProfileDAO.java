package appagency.dao;

import appagency.form.UserForm;
import appagency.model.User;

import java.math.BigInteger;
import java.util.List;

public interface ProfileDAO {
    User getUserByLogin(String email);
    void createUser(UserForm userForm);
    Integer checkEmail(String email);
}
