package com.BookXChange.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Exchange")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ID;
    BookModel selectedBook;
    UserModel selectedBookUser;
    BookModel offeredBook;
    UserModel offeredBookUser;




}
