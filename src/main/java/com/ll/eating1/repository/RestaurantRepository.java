package com.ll.eating1.repository;

import com.ll.eating1.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT * FROM restaurants WHERE ST_Distance_Sphere(Point(longitude, latitude), Point(:lng, :lat)) <= :radius", nativeQuery = true)
    List<Restaurant> findNearby(@Param("lat") double lat, @Param("lng") double lng, @Param("radius") double radius);


    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.keywords) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Restaurant> searchByKeyword(@Param("keyword") String keyword);


    Restaurant findByName(String name);
}

