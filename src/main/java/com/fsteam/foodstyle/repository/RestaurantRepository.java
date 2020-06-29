package com.fsteam.foodstyle.repository;

import com.fsteam.foodstyle.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    public List<Restaurant> findAllByCategory(Integer category);
}