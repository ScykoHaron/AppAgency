package appagency.service;

import appagency.dao.ProfileDAOImpl;
import appagency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDAOImpl profileDAO;

    @Override
    public User findUserById(BigInteger id) {
        return profileDAO.getUserById(id);
    }
}
