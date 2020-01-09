package appagency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToursController {
    @GetMapping("/tours")
    public String getToursPage(){
        return "tours";
    }
}
