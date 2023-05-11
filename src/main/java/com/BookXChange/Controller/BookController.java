package com.BookXChange.Controller;

import com.BookXChange.Model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.BookXChange.Services.BookService;


@Controller

@RequestMapping("/book")
public class BookController {


    BookService bookservice;
    @Autowired
    public BookController(BookService _bookservice){
        this.bookservice = _bookservice;
    }
    
    @GetMapping(path = "/bookupload")
    public String uploadBook(Model model){

        model.addAttribute("addBookDetails", new BookModel());
        return "book/BookUpload";
    }

   @PostMapping(path = "/processbookupload")
    public String process_uploadBook(@ModelAttribute BookModel book){
        bookservice.addBook(book);
        return "redirect:/book/bookupload";
    }

    @GetMapping(path = "/getAllBooks")
    public String allBooks(Model model){
        model.addAttribute("booksList",bookservice.getAllBooks());
        return "book/allbooks";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id){
        bookservice.deleteBookByID(id);
        return "redirect:/books/getAllBooks";
    }

    @PostMapping("/updateBook")
    public String updateBook( @ModelAttribute BookModel bookModel ){
        bookservice.updateBookByID(bookModel.getBookID(), bookModel);
        var bookId = bookModel.getBookID().toString();
        return "redirect:/books/bookDetail/" + bookId;
    }

    @GetMapping("/updateBookPage/{id}")
    public String updateBookPage(@PathVariable("id") long id, Model model){
        var bookToBeUpdated = bookservice.getBookByID(id);
        model.addAttribute("bookUpdate", bookToBeUpdated);
        return "book/bookUpdatePage";
    }

}
