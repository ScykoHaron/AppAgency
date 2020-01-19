package appagency.dao;

import appagency.form.UserForm;
import appagency.model.User;

public interface ProfileDAO {
    User getUserByLogin(String login);
    void createUser(UserForm userForm);
}
