package com.ll.eating1.controller;

import com.ll.eating1.dto.MyFavoriteRequest;
import com.ll.eating1.dto.MypageRequest;

import com.ll.eating1.entity.Mypage;
import com.ll.eating1.entity.PopularKeyword;
import com.ll.eating1.entity.Restaurant;
import com.ll.eating1.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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





    // 인기 키워드 조회
    @GetMapping("/popular-keywords")
    public List<String> getPopularKeywords() {
        return restaurantService.getTopKeywords();
    }

    // 키워드 검색
    @GetMapping("/keyword-search")
    public List<Restaurant> searchRestaurantsByKeyword(@RequestParam(required = true) String keyword) {
        return restaurantService.getRestaurantsByKeyword(keyword);
    }

    // 찜 목록에 추가
    @PostMapping("/mypage/favorites")
    public ResponseEntity<Map<String, String>> addToFavorites(@RequestBody MyFavoriteRequest request) {
        boolean isAdded = restaurantService.saveToFavorites(request.getEmail(), request.getRestaurantId());

        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("message", "찜 목록에 추가되었습니다!");
        } else {
            response.put("message", "이미 찜 목록에 존재하는 식당입니다.");
        }
        return ResponseEntity.ok(response);
    }


    // 찜 목록 조회
    @GetMapping("/mypage/favorites")
    public List<Restaurant> getFavoriteRestaurants(@RequestParam String email) {
        return restaurantService.getFavoriteRestaurants(email);
    }

    // 리뷰저장
    @PostMapping("/mypage")
    public ResponseEntity<String> saveReview(@RequestBody MypageRequest request) {
        restaurantService.saveMypage(request.getReviewer(), request.getRestaurantId(), request.getKeywords(), request.getReview());
        return ResponseEntity.ok("리뷰가 mypage에 저장되었습니다!");
    }
}


