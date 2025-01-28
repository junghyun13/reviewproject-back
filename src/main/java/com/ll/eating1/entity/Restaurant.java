package com.ll.eating1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private double rating;
    private String review;
    private String category;
    private double latitude;
    private double longitude;
    private String keywords;
    private String reviewer;


    // 나머지 필드도 마찬가지로 추가
}
