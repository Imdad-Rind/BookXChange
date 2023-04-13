package com.BookXChange.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/book_upload")
    public String uploadBook(){

        return "book/bookUpload";
    }
}
