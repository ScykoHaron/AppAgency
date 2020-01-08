package appagency.dao;

import appagency.model.User;

import java.math.BigInteger;

public interface ProfileDAO {
    User getUserById(BigInteger id);
}
