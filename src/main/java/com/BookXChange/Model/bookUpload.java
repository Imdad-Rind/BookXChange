package com.BookXChange.Model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Getter
@Setter
public class bookUpload {
    
   public String bookname;
   public String authorname;
   public String publishedyear;
   public String condition;
   public String price;
    
    
}
