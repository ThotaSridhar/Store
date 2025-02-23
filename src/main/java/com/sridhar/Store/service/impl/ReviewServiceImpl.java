package com.sridhar.Store.service.impl;

import com.sridhar.Store.domain.Book;
import com.sridhar.Store.domain.Review;
import com.sridhar.Store.repositories.BookRepository;
import com.sridhar.Store.repositories.ReviewRepository;
import com.sridhar.Store.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public Review addReview(Review review, Integer bookId) {
        Optional< Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()) return null;
        review.setBook(bookOptional.get());
        reviewRepository.save(review);
        return review;
    }

    @Override
    public void deleteReview(Integer id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()) return ;
        reviewRepository.deleteById(id);
    }
}
