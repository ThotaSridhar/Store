package com.sridhar.Store.domain;


//import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@Entity
//@Table(name="book")
public class Book {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    String name;
    String author;
    Genre genre;

    @Min(value = 10,message = "Minimum value should be of 10")
    @Max(value = 1000, message = "Maximum value should be of 1000")
    Double cost;
    @Min(value = 2000)
    Integer year;
//    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    List<Review> reviewList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
