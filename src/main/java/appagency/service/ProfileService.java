package appagency.service;

import appagency.model.User;

import java.math.BigInteger;

public interface ProfileService {
    User findUserById(BigInteger id);
}
