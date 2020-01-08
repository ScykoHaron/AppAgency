package appagency.service;

import appagency.model.User;

import java.math.BigInteger;
import java.util.List;

public interface ProfileService {
   User findUserById(BigInteger id);
}
