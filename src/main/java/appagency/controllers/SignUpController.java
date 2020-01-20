package appagency.controllers;

import appagency.form.UserForm;
import appagency.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        if(signUpService.getUserByLogin(userForm.getEmail()) == null) {
            signUpService.addUser(userForm);
            return "redirect:/start";
        }
        else {
            if(signUpService.getUserByLogin(userForm.getEmail()).isActive()) {
                model.addAttribute("error", true);
                return "signup";
            }
            else {
                signUpService.updateUser(userForm);
                return "redirect:/start";
            }
        }
    }
}
