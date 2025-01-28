package com.ll.eating1.repository;

import com.ll.eating1.entity.MyFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyFavoriteRepository extends JpaRepository<MyFavorite, Long> {

    // 특정 리뷰어(email)의 찜 목록을 조회
    List<MyFavorite> findByUserEmail(String email);

    // 특정 리뷰어와 식당에 대한 찜이 이미 존재하는지 체크
    Optional<MyFavorite> findByUserEmailAndRestaurantId(String email, Long restaurantId);
}
