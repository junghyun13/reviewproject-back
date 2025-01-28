package com.ll.eating1.service;

import com.ll.eating1.entity.Restaurant;
import com.ll.eating1.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getNearbyRestaurants(double lat, double lng, double radius) {
        List<Restaurant> results = restaurantRepository.findNearby(lat, lng, radius);
        System.out.println("쿼리 결과 (Nearby): " + results);
        return results;
    }

    public List<Restaurant> searchByKeyword(String keyword) {
        List<Restaurant> results = restaurantRepository.searchByKeyword(keyword);
        System.out.println("쿼리 결과 (Search): " + results);
        return results;
    }



    public Restaurant getRestaurantDetails(String name) {
        return restaurantRepository.findByName(name);
    }
}

