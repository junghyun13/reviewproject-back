package com.ll.eating1.dto;

import lombok.Data;

@Data
public class MyFavoriteRequest {
    private String email;  // 사용자 이메일
    private Long restaurantId;  // 식당 ID

    // Getters and Setters
}
