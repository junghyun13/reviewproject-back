package com.ll.eating1.service;

import com.ll.eating1.entity.*;
import com.ll.eating1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MypageRepository mypageRepository;

    @Autowired
    private PopularKeywordRepository popularKeywordRepository;

    @Autowired
    private MyFavoriteRepository myFavoriteRepository;

    @Autowired
    private UserRepository userRepository;

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


    public List<Restaurant> getRestaurantsByKeyword(String keyword) {
        return restaurantRepository.searchByKeyword(keyword);
    }

    public Restaurant getRestaurantDetails(String name) {
        return restaurantRepository.findByName(name);
    }

    // 찜 목록에 추가
    public boolean saveToFavorites(String email, Long restaurantId) {
        Optional<MyFavorite> existingFavorite = myFavoriteRepository.findByUserEmailAndRestaurantId(email, restaurantId);
        if (existingFavorite.isPresent()) {
            return false;  // 이미 찜 목록에 존재하는 경우
        }

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MyFavorite favorite = new MyFavorite();
        favorite.setUser(user);  // User를 외래키로 설정
        favorite.setRestaurant(restaurant);  // Restaurant를 설정

        myFavoriteRepository.save(favorite);
        return true;  // 찜 목록에 추가된 경우
    }

    // 찜 목록 조회
    public List<Restaurant> getFavoriteRestaurants(String email) {
        List<MyFavorite> favorites = myFavoriteRepository.findByUserEmail(email);
        return favorites.stream()
                .map(MyFavorite::getRestaurant)  // MyFavorite에서 Restaurant 객체 반환
                .collect(Collectors.toList());
    }


    public void saveMypage(String reviewer, Long restaurantId, String keywords, String review) {
        System.out.println("Restaurant ID: " + restaurantId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant with ID " + restaurantId + " not found"));

        System.out.println("Restaurant Found: " + restaurant);

        Mypage mypage = new Mypage();
        mypage.setReviewer(reviewer);
        mypage.setRestaurant(restaurant);
        mypage.setKeywords(keywords);
        mypage.setReview(review);

        mypageRepository.save(mypage);
        System.out.println("Mypage Saved: " + mypage);
    }

    public List<String> getTopKeywords() {
        return popularKeywordRepository.findTop10Keywords();
    }
}

/*
public void saveMypage(String reviewer, Long restaurantId, String keywords, String review) {
        System.out.println("Restaurant ID: " + restaurantId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant with ID " + restaurantId + " not found"));

        System.out.println("Restaurant Found: " + restaurant);

        Mypage mypage = new Mypage();
        mypage.setReviewer(reviewer);
        mypage.setRestaurant(restaurant);
        mypage.setKeywords(keywords);
        mypage.setReview(review);

        mypageRepository.save(mypage);
        System.out.println("Mypage Saved: " + mypage);
    }
 */