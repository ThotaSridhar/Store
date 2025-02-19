package com.sridhar.Store.controller;


import com.sridhar.Store.domain.Book;
import com.sridhar.Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @GetMapping("/user/books")
    public ResponseEntity<?> getBooks(){
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/book")
    public ResponseEntity<?> getBook(@RequestParam("id") Integer id){
        Book book = bookService.getBook(id);
        if(book==null){
            return new ResponseEntity<>("No book is found with given id ",HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
    }
}
