package com.BookXChange.Services;

import java.util.ArrayList;
import java.util.List;

import com.BookXChange.Model.BookModel;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    List<BookModel> uploadedBooks = new ArrayList<>();


    public void addBook(BookModel book){

        uploadedBooks.add(book);
    }


}
