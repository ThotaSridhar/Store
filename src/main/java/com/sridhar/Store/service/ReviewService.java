package com.sridhar.Store.service;

import com.sridhar.Store.domain.Review;

public interface ReviewService {
    public Review addReview(Review review, Integer bookId);
    public void deleteReview(Integer id);
}
