package com.BookXChange.Services;

import java.util.ArrayList;
import java.util.List;

import com.BookXChange.Model.BookModel;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    List<BookModel> uploadedBooks = new ArrayList<>();
    long bookId = -1;

    public void addBook(BookModel book){
        long myBookID = bookId = bookId + 1;
        book.setBookID(myBookID);
        uploadedBooks.add(book);
    }

    public List<BookModel> getAllBooks(){
        return uploadedBooks;
    }

    public BookModel getBookByID(long id){
        for (BookModel book : uploadedBooks ){
            if (book.getBookID().equals(id)){
                return book;
            }
        }
        return null;

    }
    public void deleteBook(long id){
        uploadedBooks.remove(getBookByID(id));
    }

    public void updateBookDetail(long id, BookModel bookModel){
        uploadedBooks.set(uploadedBooks.indexOf(getBookByID(id)), bookModel );
    }


}
