package com.sridhar.Store.repositories;

import com.sridhar.Store.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where id between ?1 and ?2",nativeQuery = true)
    public List<Book> getByRange(Integer start,Integer end);
}
