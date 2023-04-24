package com.BookXChange.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter
public class BookModel {
    Long BookID;
    String BookTitle;
    String BookAuthor;
    String BookDescription;
    String PublishedYear;
    String Condition;
    Double Price;
}
