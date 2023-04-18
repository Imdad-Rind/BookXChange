package com.BookXChange.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BookXChange.Model.bookUpload;

@Service
public class BookService {

    List<bookUpload> uploadedbooks = new ArrayList<>();


    public void addBook(bookUpload book){

        uploadedbooks.add(book);
    }

    // public List<bookUpload> getList(){

    //     return uploadedbooks;
    // }
}
