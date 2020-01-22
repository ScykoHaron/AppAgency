package appagency.controllers;

import appagency.model.User;
import appagency.security.details.UserDetailsImpl;
import appagency.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/orders")
    public String getOrdersPage(ModelMap model, Authentication authentication) {
        if(authentication == null){
            return "redirect:/start";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        model.addAttribute("userOrders",orderService.getOrder(user.getUserId()));
        return "orders";
    }

}
