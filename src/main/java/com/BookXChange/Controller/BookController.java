package com.BookXChange.Controller;

import com.BookXChange.Model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.BookXChange.Services.BookService;
import org.yaml.snakeyaml.constructor.Constructor;


@Controller
@RequestMapping("/books")
public class BookController {


    BookService bookservice;
    @Autowired
    public BookController(BookService _bookservice){
        this.bookservice = _bookservice;
    }
    
    @GetMapping("/bookUpload")
    public String uploadBook(Model model){

        model.addAttribute("addBookDetails", new BookModel());
        return "book/BookUpload";
    }

   @PostMapping( "/processBookUpload")
    public String processBookUpload(@ModelAttribute BookModel book){
        bookservice.addBook(book);
        return "redirect:/books/getAllBooks";
    }

    @GetMapping("/getAllBooks")
    public String getAllBooksList(Model model){
       var BooksList = bookservice.getAllBooks();
       model.addAttribute("booksList",BooksList);
       return "book/allBooks";

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
