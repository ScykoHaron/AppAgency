package appagency.service;

import appagency.dao.ProfileDao;
import appagency.form.UserForm;
import appagency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    ProfileDao profileDao;

    @Override
    public void addUser(UserForm userForm) {
        profileDao.createUser(userForm);
    }

    @Override
    public User getUserByLogin(String login) {
        return profileDao.getUserByLogin(login);
    }

    @Override
    public void updateUser(UserForm userForm) {
        profileDao.updateUser(userForm);
    }
}
