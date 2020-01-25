package appagency.controllers;

import appagency.model.User;
import appagency.security.details.UserDetailsImpl;
import appagency.service.OrderServiceImpl;
import appagency.service.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class ToursController {

    @Autowired
    TourServiceImpl tourService;

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/tours")
    public String getToursPage(ModelMap model){
        model.addAttribute("allTours",tourService.getTours());
        return "tours";
    }

    @PostMapping("/tours")
    public String bookingTour(@RequestParam(name = "tour") BigInteger tourId, Authentication authentication){
        if (authentication == null) {
            return "redirect:/start";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        tourService.decreaseCount(tourId);
        orderService.addOrder(user.getUserId(),tourId);
        return "redirect:/tours";
    }
}
