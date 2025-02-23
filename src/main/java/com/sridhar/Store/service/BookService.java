package com.sridhar.Store.service;

import com.sridhar.Store.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    public Book addBook(Book book);
    public Book updateBook(Integer id, Book book);
    public void deleteBook(Integer id);
    public Book getBook(Integer id);
    public List<Book> getBookByRange(Integer start,Integer end);
    public List<Book> getBooks();
}
