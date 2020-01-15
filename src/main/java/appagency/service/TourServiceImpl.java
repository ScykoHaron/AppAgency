package appagency.service;

import appagency.dao.TourDAOImpl;
import appagency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourDAOImpl tourDAO;

    @Override
    public List<Tour> getTours() {
        return tourDAO.getTours();
    }
}
