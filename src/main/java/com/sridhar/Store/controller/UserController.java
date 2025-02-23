package com.sridhar.Store.controller;


import com.sridhar.Store.domain.Book;
import com.sridhar.Store.domain.Review;
import com.sridhar.Store.service.BookService;
import com.sridhar.Store.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/user/books")
    public ResponseEntity<?> getBooks(){
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/book_by_range")
    public ResponseEntity<?> getBookByRange(@RequestParam(value = "start",required = false) Integer start,@RequestParam(value = "end",required = false) Integer end){
        if(start==null || end==null) return getBooks();
        List<Book> books = bookService.getBookByRange(start,end);
        return new ResponseEntity<>(books,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/book")
    public ResponseEntity<?> getBook(@RequestParam("id") Integer id){
        Book book = bookService.getBook(id);
        if(book==null){
            return new ResponseEntity<>("No book is found with given id ",HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
    }

    @PostMapping("/user/addReview")
    public ResponseEntity<?> addReview(@Valid @RequestBody Review review, @RequestParam("book_id") Integer book_id){
        Review review1 = reviewService.addReview(review,book_id);
        if(review1==null) return new ResponseEntity<>("No Valid book is found ",HttpStatusCode.valueOf(400));
        return new ResponseEntity<>(bookService.getBook(book_id),HttpStatusCode.valueOf(201));
    }
}
