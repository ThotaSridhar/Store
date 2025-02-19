package com.sridhar.Store.controller;


import com.sridhar.Store.domain.Book;
import com.sridhar.Store.service.BookService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;

    @PostMapping("/admin/book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        Book book1 = bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/admin/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        Integer id = book.getId();
        Book book1 = bookService.updateBook(id,book);
        if(book1==null) return new ResponseEntity<>("No book is available with given id",HttpStatusCode.valueOf(204));
        return  new ResponseEntity<>(book1, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/admin/book{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }


}

