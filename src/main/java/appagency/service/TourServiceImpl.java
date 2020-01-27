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
    public void increaseCount(BigInteger id) {
        tourDao.increaseCount(id);
    }

    @Override
    public void decreaseCount(BigInteger id) {
        tourDao.decreaseCount(id);
    }
}
