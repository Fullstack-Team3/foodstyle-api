package com.fsteam.foodstyle.repository;

import com.fsteam.foodstyle.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findAllByRestaurantid(Long restaurantid);
}
