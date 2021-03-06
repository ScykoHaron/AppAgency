package appagency.dao;

import appagency.form.UserForm;
import appagency.model.User;

public interface ProfileDao {
    User getUserByLogin(String login);

    void createUser(UserForm userForm);

    void updateUser(UserForm userForm);

    void deleteUser(String login);

    void editUser(String field, String value, String login);
}
