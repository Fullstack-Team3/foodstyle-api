package com.fsteam.foodstyle.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fsteam.foodstyle.domain.Restaurant;
import com.fsteam.foodstyle.domain.User;
import com.fsteam.foodstyle.repository.RestaurantRepository;
import com.fsteam.foodstyle.repository.UserRepository;
import com.fsteam.foodstyle.vm.LoginVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/managers")
    @ResponseBody
    public List<User> findAllManagers(){
        return userRepository.findAllByUserType(1);
    }

    @PostMapping("/managers")
    @ResponseBody
    public User createManager(@RequestBody User user){
        user.setUserType(1);
        if (user.getRestaurantid() != null) {
            Optional<Restaurant> optRes = restaurantRepository.findById(user.getRestaurantid());
            if (optRes != null && optRes.isPresent()){
                user.setRestaurantname(optRes.get().getName());
            }
        }
        return userRepository.save(user);
    }

    @PutMapping("/managers")
    @ResponseBody
    public User updateManager(@RequestBody User user){
        if (user.getId() == null){
            System.out.println("User id cannot be null.");
            return null;
        }
        if (user.getRestaurantid() != null) {
            Optional<Restaurant> optRes = restaurantRepository.findById(user.getRestaurantid());
            if (optRes != null && optRes.isPresent()){
                user.setRestaurantname(optRes.get().getName());
            }
        }
        user.setUserType(1);
        return userRepository.save(user);
    }

    @GetMapping("/managers/{id}")
    @ResponseBody
    public User createManager(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/managers/{id}")
    @ResponseBody
    public Long deleteManager(@PathVariable Long id){
        userRepository.deleteById(id);
        return id;
    }

    @PostMapping("/users-register")
    @ResponseBody
    public User registerUser(@RequestBody User user){
        user.setUserType(2);
        return userRepository.save(user);
    }

    @PostMapping("/users-login")
    @ResponseBody
    public Map<String, Object> userLogin(@RequestBody LoginVM loginVM){
        User user = userRepository.findFirstByEmailAndPassword(loginVM.getEmail(), loginVM.getPassword());
        Map<String, Object> map = new HashMap<>();
        if (user != null){
            map.put("success", 1);
            map.put("userid", user.getId());
            map.put("username", user.getFirstname());
        }else {
            map.put("success", 0);
            map.put("message", "Login failed, please check your email and password!");
        }
        return map;
    }

    @GetMapping("/managers-login")
    @ResponseBody
    public User managerLogin(){
        User user = new User();
        user.setEmail("longfei@email.com");
        user.setFirstname("Longfei");
        user.setLastname("Wang");
        user.setPassword("123456");
        user.setUserType(2);
        return userRepository.save(user);
    }
}
