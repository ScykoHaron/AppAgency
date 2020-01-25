package appagency.controllers;

import appagency.model.User;
import appagency.security.details.UserDetailsImpl;
import appagency.service.OrderService;
import appagency.service.OrderServiceImpl;
import appagency.service.TourService;
import appagency.service.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.time.LocalDate;

@Controller
public class OrdersController {

    @Autowired
    OrderService orderService;

    @Autowired
    TourService tourService;

    @GetMapping("/orders")
    public String getOrdersPage(ModelMap model, Authentication authentication, HttpServletRequest request) {
        if (authentication == null) {
            return "redirect:/start";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        model.addAttribute("userOrders", orderService.getOrder(user.getUserId()));
        return "orders";
    }

    @PostMapping("/orders")
    public String delOrder(@RequestParam(name = "order") BigInteger id,@RequestParam(name = "tour") BigInteger tourId, @RequestParam(name = "startdate") String startDate) {
        LocalDate date = LocalDate.now();
        if (date.isEqual(LocalDate.parse(startDate)) || date.isAfter(LocalDate.parse(startDate))) {
            return "redirect:/orders?error";
        } else {
            orderService.delOrder(id);
            tourService.increaseCount(tourId);
            return "redirect:/orders";
        }
    }

}
