package appagency.controllers;

import appagency.model.User;
import appagency.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@Controller
public class ProfileController {
    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/user/{user-id}")
    public String getUser(@PathVariable("user-id") BigInteger id, ModelMap model){
        model.addAttribute("user", profileService.findUserById(id));
        return "users";
    }

}
