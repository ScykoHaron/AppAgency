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
    public User findUserByLogin(String login) {
        return profileDAO.getUserByLogin(login);
    }
}
