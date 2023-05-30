package com.BookXChange.Services;

import java.util.List;

import com.BookXChange.Model.BookModel;
import com.BookXChange.Model.UserModel;
import com.BookXChange.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){this.bookRepository = bookRepository;}



    public void addBook(BookModel book){
        bookRepository.save(book);
    }
    public List<BookModel> getAllBooks(){
       return bookRepository.findAll();
    }
    public BookModel getBookByID(long id){
        return bookRepository.findById(id).get();
    }
    public void updateBookByID(long id,BookModel bookModel){
        BookModel bookToBeUpdated = getBookByID(id);
        bookToBeUpdated = bookModel;
        bookRepository.save(bookToBeUpdated);
    }

    public void deleteBookByID(long id){
        bookRepository.deleteById(id);
    }

    public List<BookModel> getBookByUser(UserModel user){
        return bookRepository.findAllBookByUser(user);
    }



}
