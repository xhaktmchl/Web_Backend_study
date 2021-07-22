package com.sparta_spring.sparta_spring_week04.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // DB 테이블 역할을 합니다.
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 빈 생성자
public class Product extends Timestamped{

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
    private String image;

    // 상품 링크
    @Column(nullable = false)
    private String link;

    // 최저가
    @Column(nullable = false)
    private int lprice;

    // 내 상품 가격
    @Column(nullable = false)
    private int myprice;

    // 관심상품 등록시 필요한 생성자
    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice =0; // 내가 등록한 가격
    }

    // 관심상품의 최저가격 업데이트 메서드
    public void update(ProductMypriceRequestDto requestDto){
        this.myprice = requestDto.getMyprice();
    }

    // 스케줄러로 itemDto를 매개체로 관심상품의 치저가만 업데이트
    public void updateByItemDto(ItemDto itemDto){
        this.lprice = itemDto.getLprice();
    }
}
