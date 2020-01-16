package appagency.controllers;


import appagency.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProfileController {
    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/user/{email}")
    public String getUser(@PathVariable("email") String email, ModelMap model){
        model.addAttribute("user", profileService.findUserByLogin(email));
        return "users";
    }

}
