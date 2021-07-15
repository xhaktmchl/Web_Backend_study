package com.sparta_spring.sparta_spring_week04.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // 테이블 역할
@Getter
@NoArgsConstructor // 빈 생성자
public class Product {

    // ID
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동생성
    @Id
    private Long id;

    // 열
    // 상품 이름
    @Column(nullable = false)
    private String title;

    // 상품 사진
    @Column(nullable = false)
    private String img;

    // 상품 링크
    @Column(nullable = false)
    private String link;

    // 최저가
    @Column(nullable = false)
    private int lprice;

    // 내 상품 가격
    @Column(nullable = false)
    private int myprice;
}
