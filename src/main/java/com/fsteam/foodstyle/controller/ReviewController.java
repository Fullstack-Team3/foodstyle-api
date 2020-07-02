package com.fsteam.foodstyle.controller;

import com.fsteam.foodstyle.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fsteam.foodstyle.domain.Review; // Added
import com.fsteam.foodstyle.repository.ReviewRepository; // Added

import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository; // Added

    @PostMapping("/post-review")
    @ResponseBody
    public Review postReview(@RequestBody Review rev){
        return reviewRepository.save(rev);
    }

}
