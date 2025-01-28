package com.ll.eating1.repository;

import com.ll.eating1.entity.Mypage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MypageRepository extends JpaRepository<Mypage, Long> {
    @Query("SELECT DISTINCT m.restaurant FROM Mypage m WHERE m.reviewer = :reviewer")
    Optional<Mypage> findByReviewerAndRestaurantId();
}

