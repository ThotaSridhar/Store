package com.sridhar.Store.domain;


//import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name="review")
public class Review {

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;

    @NotBlank(message = "review shouldn't be blank")
    String review;
    @Max(value = 5,message = "shouldn't be greater than 5")
    @Min(value = 1,message = "rating should be minimum of 1")
    Integer rating;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book_id")
    Book book;
}
