package com.ll.eating1.dto;

import lombok.Data;

@Data
public class MypageRequest {
    private String reviewer;
    private Long restaurantId;
    private String keywords;
    private String review;
}
