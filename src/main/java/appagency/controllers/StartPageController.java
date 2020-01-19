package appagency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StartPageController {
    @GetMapping("/start")
    public String getStartPage(ModelMap model, HttpServletRequest request){
        if(request.getParameterMap().containsKey("error")){
            model.addAttribute("error",true);
       }
        return "startpage";
    }
}
