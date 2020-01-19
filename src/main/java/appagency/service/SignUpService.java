package appagency.service;

import appagency.form.UserForm;
import appagency.model.User;

public interface SignUpService {
    void addUser(UserForm userForm);
    User getUserByLogin(String login);
}
