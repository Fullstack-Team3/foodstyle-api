package com.fsteam.foodstyle.controller;

import com.fsteam.foodstyle.domain.Food;
import com.fsteam.foodstyle.domain.User;
import com.fsteam.foodstyle.vm.FoodVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fsteam.foodstyle.domain.Food; // Added
import com.fsteam.foodstyle.repository.FoodRepository; // Added

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FoodController {
    @Autowired
    private FoodRepository foodRepository; // Added

    // Add function to retrieve food data
    @GetMapping("/food-list")
    @ResponseBody
    public List<Food> findAllFood(){
        return foodRepository.findAllByRestaurantid(1L);
    }

    @PostMapping("/food")
    @ResponseBody
    public Food createFood(@RequestBody Food food){
        return foodRepository.save(food);
    }

    @GetMapping("/food/{id}")
    @ResponseBody
    public Food findOneFood(@PathVariable Long id){
        return foodRepository.findById(id).get();
    }

    @DeleteMapping("/food/{id}")
    @ResponseBody
    public Long deleteFood(@PathVariable Long id){
        foodRepository.deleteById(id);
        return id;
    }

    @PutMapping("/food")
    @ResponseBody
    public Food updateFood(@RequestBody Food food){
        if (food.getId() == null){
            System.out.println("Food id cannot be null.");
            return null;
        }
        return foodRepository.save(food);
    }

    @GetMapping("/food")
    @ResponseBody
    public List<Food> findAllFoods(){
        return foodRepository.findAll();
    }

    @PostMapping("/food/search")
    @ResponseBody
    public List<Food> findFoodsByRestaurantAndNameLike(@RequestBody FoodVM foodVM){
        return foodRepository.findAllByRestaurantidAndNameLike(foodVM.getRestaurantId(),"%" + foodVM.getFoodName() + "%");
    }
}
