package appagency.service;

import appagency.dao.ProfileDAOImpl;
import appagency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDAOImpl profileDAO;

    @Override
    public void deleteUser(String login) {
        profileDAO.deleteUser(login);
    }

    @Override
    public void editUser(String field, String value, String login) {
        profileDAO.editUser(field, value, login);
    }
}
