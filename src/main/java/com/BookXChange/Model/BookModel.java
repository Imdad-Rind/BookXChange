package com.BookXChange.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

import java.time.LocalDate;
// import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "Books")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long BookID;
    String BookTitle;
    String BookAuthor;
    String BookDescription;
    LocalDate PublishedYear;
    String Condition;
    Double Price;
}
