package appagency.controllers;

import appagency.model.User;
import appagency.security.details.UserDetailsImpl;
import appagency.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/edit")
    public String getEditPage(Authentication authentication){
        if(authentication == null){
            return "redirect:/start";
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String editFirstName(@RequestParam(name = "value") String value, @RequestParam(name = "field") String field, Authentication authentication){
        if (authentication == null) {
            return "redirect:/start";
        }

        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        profileService.editUser(field,value,user.getEmail());
        return "redirect:/edit";
    }
}
