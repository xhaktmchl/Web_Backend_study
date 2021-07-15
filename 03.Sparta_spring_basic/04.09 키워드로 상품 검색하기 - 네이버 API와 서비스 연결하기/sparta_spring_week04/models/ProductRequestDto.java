package com.sparta_spring.sparta_spring_week04.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// 정보를 전달하는 매개체이므로 정보를 담고 생성,조회기능있어야 됨
@Getter
@Setter
@RequiredArgsConstructor
public class ProductRequestDto { // 관심상품 등록정보 매개체

    private String title; // 상품이름
    private String image; // 상품사진
    private int lprice; // 상품 최저가
    private String link; // 상품 링크크

}