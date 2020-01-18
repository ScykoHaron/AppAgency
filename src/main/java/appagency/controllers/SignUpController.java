package appagency.controllers;

import appagency.form.UserForm;
import appagency.model.User;
import appagency.service.ProfileServiceImpl;
import appagency.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SignUpController {

    @Autowired
    private SignUpServiceImpl signUpService;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(UserForm userForm, ModelMap model) {
        if(signUpService.check(userForm.getEmail()) == 0) {
            signUpService.addUser(userForm);
            return "redirect:/start";
        }
        else {
            model.addAttribute("error", true);
            return "signup";
        }
    }
}
