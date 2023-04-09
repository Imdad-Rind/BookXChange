package com.BookXChange.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter
public class BookModel {
    UUID BookID;
    String BookTile;
    String BookAuthor;
    String BookDescription;
}
