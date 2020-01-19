package appagency.controllers;


import appagency.model.User;
import appagency.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(ModelMap model, Authentication authentication){
        if(authentication == null){
            return "redirect:/start";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        model.addAttribute("user",user);
        return "profile";
    }

}
