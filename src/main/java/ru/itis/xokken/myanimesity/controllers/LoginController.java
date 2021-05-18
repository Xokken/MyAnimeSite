package ru.itis.xokken.myanimesity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.xokken.myanimesity.dto.NewUserForm;
import ru.itis.xokken.myanimesity.services.UserService;

@Controller
@Slf4j
public class LoginController {
    private final String MESSAGE = "The entered data is incorrect!";

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String getSignIPage(){
        return "login";
    }

    @PostMapping("/signup")
    public String getSignUpPage(NewUserForm userForm, Model model){
        if (!(userForm.getPassword1().equals(userForm.getPassword2()))){
            model.addAttribute("message", MESSAGE);
            return "login";
        }
        log.info(userForm.toString());
        userService.addNewUser(userForm);
        return "redirect:/signin";
    }

}
