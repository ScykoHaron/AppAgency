package appagency.controllers;

import appagency.service.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToursController {

    @Autowired
    TourServiceImpl tourService;

    @GetMapping("/tours")
    public String getToursPage(ModelMap model){
        model.addAttribute("allTours",tourService.getTours());
        return "tours";
    }
}
