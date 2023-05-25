package com.BookXChange.Controller;

import com.BookXChange.Model.RegistrationForm;
import com.BookXChange.Services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    UserServices userServices;
    public AuthController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("/processRegister")
    public String processRegister (RegistrationForm form){
        userServices.saveUser(form);
        return "redirect:/auth/login";
    }


}
