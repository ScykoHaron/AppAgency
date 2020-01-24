package appagency.service;

import appagency.model.User;

import java.math.BigInteger;
import java.util.List;

public interface ProfileService {
    void deleteUser(String login);
    void editUser(String field, String value,String login);
}
