package appagency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartPageController {
    @GetMapping("/start")
    public String getStartPage(){
        return "startpage";
    }

    @PostMapping("/start")
    public String getPage() {return "tours";}
}
