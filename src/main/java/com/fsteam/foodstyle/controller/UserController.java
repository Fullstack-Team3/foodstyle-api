package com.fsteam.foodstyle.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fsteam.foodstyle.domain.User;
import com.fsteam.foodstyle.repository.UserRepository;
import com.fsteam.foodstyle.vm.LoginVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fsteam.foodstyle.domain.Food; // Added
import com.fsteam.foodstyle.repository.FoodRepository; // Added

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
//    private FoodRepository foodRepository; // Added

    @GetMapping("/managers")
    @ResponseBody
    public List<User> findAllManagers(){
        return userRepository.findAllByUserType(1);
    }

    @GetMapping("/managers-save")
    @ResponseBody
    public User createManager(){
        User user = new User();
        user.setEmail("longfei@email.com");
        user.setFirstname("Longfei");
        user.setLastname("Wang");
        user.setPassword("123456");
        user.setUserType(1);
        return userRepository.save(user);
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

//    // Add function to retrieve food data
//    @GetMapping("/food-list")
//    @ResponseBody
////    public List<Food> findAllFood(){
////        return foodRepository.findAllByRestaurantid((long) 1);
////    }
////    public String findAllFood(){
////        return "It works";
////    }
//    public Food findAllFood(){
//        return foodRepository.findByName("Food Combo 1");
//    }
}
