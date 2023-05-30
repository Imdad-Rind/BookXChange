package com.BookXChange.Repository;

import com.BookXChange.Model.BookModel;
import com.BookXChange.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Long> {

    List<BookModel> findAllBookByUser(UserModel user);
}
