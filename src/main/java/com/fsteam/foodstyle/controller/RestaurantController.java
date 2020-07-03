package com.fsteam.foodstyle.controller;

import com.fsteam.foodstyle.domain.Restaurant;
import com.fsteam.foodstyle.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/restaurants")
    @ResponseBody
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/restaurants/{id}")
    @ResponseBody
    public Restaurant findOneRestaurant(@PathVariable Long id){
        return restaurantRepository.findById(id).get();
    }

    @DeleteMapping("/restaurants/{id}")
    @ResponseBody
    public Long deleteRestaurant(@PathVariable Long id){
        restaurantRepository.deleteById(id);
        return id;
    }

    @PutMapping("/restaurants")
    @ResponseBody
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/restaurants")
    @ResponseBody
    public List<Restaurant> findAllRestaurants(){
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/category/{category}")
    @ResponseBody
    public List<Restaurant> findAllRestaurantsByCategory(@PathVariable Integer category){
        return restaurantRepository.findAllByCategory(category);
    }

    @GetMapping("/restaurants/name/{name}")
    @ResponseBody
    public List<Restaurant> findAllRestaurantsByNameLike(@PathVariable String name){
        return restaurantRepository.findAllByNameLike("%" + name + "%");
    }
}
