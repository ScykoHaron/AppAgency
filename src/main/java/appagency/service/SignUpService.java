package appagency.service;

import appagency.form.UserForm;

public interface SignUpService {
    void addUser(UserForm userForm);
    Integer check(String email);
}
