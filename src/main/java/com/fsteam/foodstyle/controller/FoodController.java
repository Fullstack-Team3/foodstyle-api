package com.fsteam.foodstyle.controller;

import com.fsteam.foodstyle.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fsteam.foodstyle.domain.Food; // Added
import com.fsteam.foodstyle.repository.FoodRepository; // Added

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    private FoodRepository foodRepository; // Added

    // Add function to retrieve food data
    @GetMapping("/food-list")
    @ResponseBody
    public List<Food> findAllFood(){
        return foodRepository.findAllByRestaurantid((long) 1);
    }

}
