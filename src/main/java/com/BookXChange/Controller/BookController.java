package com.BookXChange.Controller;

import com.BookXChange.Model.BookModel;
import com.BookXChange.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.BookXChange.Services.BookService;


@Controller

@RequestMapping("/book")
public class BookController {


    BookService bookservice;
    UserServices userServices;
    @Autowired
    public BookController(BookService _bookservice, UserServices userServices){
        this.userServices = userServices;
        this.bookservice = _bookservice;
    }
    
    @GetMapping(path = "/bookupload")
    public String uploadBook(Model model){

        model.addAttribute("addBookDetails", new BookModel());
        return "book/BookUpload";
    }

   @PostMapping(path = "/processBookUpload")
    public String process_uploadBook(@ModelAttribute BookModel book){
        book.setUser(userServices.getUserByUsername(userServices.getCurrentUser()));
        bookservice.addBook(book);
        var bookID = book.getBookID().toString();
        return "redirect:/book/bookDetail/"+bookID;
    }

    @GetMapping(path = "/getAllBooks")
    public String allBooks(Model model){
        model.addAttribute("booksList",bookservice.getAllBooks());
        return "book/allbooks";
    }
    @GetMapping("bookDetail/{id}")
    public String getBookByID(@PathVariable("id") long id, Model model){
        var bookByID = bookservice.getBookByID(id);
        model.addAttribute("book",bookByID);
        return "book/bookDetail";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id){
        bookservice.deleteBookByID(id);
        return "redirect:/book/getAllBooks";
    }

    @PostMapping("/updateBook")
    public String updateBook( @ModelAttribute BookModel bookModel ){
        bookservice.updateBookByID(bookModel.getBookID(), bookModel);
        var bookId = bookModel.getBookID().toString();
        return "redirect:/book/bookDetail/" + bookId;
    }

    @GetMapping("/updateBookPage/{id}")
    public String updateBookPage(@PathVariable("id") long id, Model model){
        var bookToBeUpdated = bookservice.getBookByID(id);
        model.addAttribute("bookUpdate", bookToBeUpdated);
        return "book/bookUpdatePage";
    }

    @GetMapping("/exchange/{id}")
    public String exchange(@PathVariable("id")long id,Model model){
        model.addAttribute("book",bookservice.getBookByID(id));
        model.addAttribute("addBookDetails", new BookModel());
        return "book/exchange";
    }

}
