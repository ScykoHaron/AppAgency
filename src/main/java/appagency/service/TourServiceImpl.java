package appagency.service;

import appagency.dao.TourDao;
import appagency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourDao tourDao;

    @Override
    public List<Tour> getTours() {
        return tourDao.getTours();
    }

    @Override
    public void increaseCount(BigInteger tourId) {
        tourDao.increaseCount(tourId);
    }

    @Override
    public void decreaseCount(BigInteger tourId) {
        tourDao.decreaseCount(tourId);
    }
}
