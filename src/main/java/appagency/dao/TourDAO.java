package appagency.dao;

import appagency.model.Tour;

import java.math.BigInteger;
import java.util.List;

public interface TourDAO {
    List<Tour> getTours();
    void increaseCount(BigInteger id);
}
