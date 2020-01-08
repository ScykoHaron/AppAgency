package appagency.dao;

import appagency.model.User;

import java.math.BigInteger;
import java.util.List;

public interface ProfileDAO {
    User getUserById(BigInteger id);
}
