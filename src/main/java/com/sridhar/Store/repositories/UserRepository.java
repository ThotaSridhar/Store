package com.sridhar.Store.repositories;

import com.sridhar.Store.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value = "select * from User where username = ?1",nativeQuery = true)
    Users findByUsername(String username);
}
