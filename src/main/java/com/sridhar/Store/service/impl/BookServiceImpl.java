package com.sridhar.Store.service.impl;

import com.sridhar.Store.domain.Book;
import com.sridhar.Store.repositories.BookRepository;
import com.sridhar.Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
      return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        Optional<Book> book1 = bookRepository.findById(id);
        if(book1.isPresent()){
            Book b = book1.get();
            b.setName(book.getName());
            b.setYear(book.getYear());
            b.setGenre(book.getGenre());
            b.setAuthor(book.getAuthor());
            b.setCost(book.getCost());
            bookRepository.save(b);
            return b;
        }
        return null;
    }

    @Override
    public void deleteBook(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(x->bookRepository.delete(x));
    }

    @Override
    public Book getBook(Integer id) {
       Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public List<Book> getBookByRange(Integer start, Integer end) {
        return bookRepository.getByRange(start,end);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
