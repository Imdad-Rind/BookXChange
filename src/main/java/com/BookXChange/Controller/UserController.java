package com.BookXChange.Controller;

import com.BookXChange.Services.BookService;
import com.BookXChange.Services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    UserServices service;
    BookService bookService;
    public UserController(UserServices services, BookService bookService) {
        this.service = services;
        this.bookService = bookService;
    }

    @GetMapping("/profile")
    public String profile(Model model){
        var user = service.getUserByUsername(service.getCurrentUser());
        var userBook = bookService.getBookByUser(user);
        model.addAttribute("userIfo",user);
        model.addAttribute("userBooks",userBook);

        return "user/userProfile";
    }
}
