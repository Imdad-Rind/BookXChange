package com.BookXChange.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookXChange.Model.bookUpload;
import com.BookXChange.Services.BookService;

 

@Controller
public class BookController {

    @Autowired
    BookService bookservice;
    
    @GetMapping(path = "/bookupload")
    public String uploadBook(Model model){
        bookUpload book = new bookUpload();
        model.addAttribute("addbookdetails", book);
        return "book/bookUpload";
    }

   @PostMapping(path = "/process_bookupload")
    public String process_uploadBook(@ModelAttribute bookUpload book){
        bookservice.addBook(book);
        return "redirect:/bookupload";
    }

}
