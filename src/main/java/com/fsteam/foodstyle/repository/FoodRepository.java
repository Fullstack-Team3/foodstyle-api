package com.fsteam.foodstyle.repository;

import com.fsteam.foodstyle.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    public List<Food> findAllByRestaurantid(Long restaurantid);
    public Food findByName(String name);
}
