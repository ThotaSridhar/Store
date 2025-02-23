package com.sridhar.Store.repositories;

import com.sridhar.Store.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
