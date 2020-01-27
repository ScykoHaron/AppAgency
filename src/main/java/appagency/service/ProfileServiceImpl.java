package appagency.service;

import appagency.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDao profileDao;

    @Override
    public void deleteUser(String login) {
        profileDao.deleteUser(login);
    }

    @Override
    public void editUser(String field, String value, String login) {
        profileDao.editUser(field, value, login);
    }
}
