package appagency.service;

import appagency.model.Tour;

import java.math.BigInteger;
import java.util.List;

public interface TourService {
    List<Tour> getTours();

    void increaseCount(BigInteger tourId);

    void decreaseCount(BigInteger tourId);
}
