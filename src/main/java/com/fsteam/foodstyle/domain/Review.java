package com.fsteam.foodstyle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long restaurantid;

    private String restaurantname;

    private Integer rating;

    private String review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public Long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", restaurantid=" + restaurantid +
                ", restaurantname='" + restaurantname + '\'' +
                ", rating='" + rating + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
