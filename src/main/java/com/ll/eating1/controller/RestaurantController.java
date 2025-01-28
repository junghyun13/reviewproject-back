package com.ll.eating1.controller;

import com.ll.eating1.entity.Restaurant;
import com.ll.eating1.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/nearby")
    public List<Restaurant> getNearbyRestaurants(@RequestParam double lat, @RequestParam double lng) {
        return restaurantService.getNearbyRestaurants(lat, lng, 2000); // 반경 2km
    }

    @GetMapping("/search")
    public List<Restaurant> searchByKeyword(@RequestParam String keyword) {
        return restaurantService.searchByKeyword(keyword);
    }

    @GetMapping("/detail")
    public Restaurant getRestaurantDetails(@RequestParam String name) {
        return restaurantService.getRestaurantDetails(name);
    }
}


