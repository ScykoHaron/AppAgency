package appagency.service;

import appagency.dao.ProfileDAOImpl;
import appagency.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    ProfileDAOImpl profileDAO;

    @Override
    public void addUser(UserForm userForm) {
        profileDAO.createUser(userForm);
    }

    @Override
    public Integer check(String email) {
        return profileDAO.checkEmail(email);
    }
}
