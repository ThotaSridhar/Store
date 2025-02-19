package com.sridhar.Store.service.impl;

import com.sridhar.Store.domain.Book;
import com.sridhar.Store.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookServiceImpl implements BookService {

    Map<Integer,Book> books = new HashMap<>();
    @Override
    public Book addBook(Book book) {
        Integer id = new Random().nextInt(1000,5000);
        book.setId(id);
        books.put(id,book);
        return book;
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        if(books.containsKey(id)){
            Book book1 = books.get(id);
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
            book1.setCost(book.getCost());
            book1.setGenre(book.getGenre());
            book1.setYear(book.getYear());
            return book1;
        }
        return null;
    }

    @Override
    public void deleteBook(Integer id) {
        books.remove(id);
    }

    @Override
    public Book getBook(Integer id) {
        if(books.containsKey(id)){
            return  books.get(id);
        }
        return null;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> res = new ArrayList<>();
        for(Map.Entry<Integer,Book> entry : books.entrySet())
        {
            res.add(entry.getValue());
        }
        return res;
    }
}
