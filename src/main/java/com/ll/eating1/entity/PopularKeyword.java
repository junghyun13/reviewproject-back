package com.ll.eating1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "popular_keyword")
@Getter
@Setter
public class PopularKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private int keywordCount; // 키워드 등장 횟수
}