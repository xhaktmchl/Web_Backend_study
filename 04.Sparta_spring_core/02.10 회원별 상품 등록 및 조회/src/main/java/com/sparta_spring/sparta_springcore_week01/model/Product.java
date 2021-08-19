package com.sparta_spring.sparta_springcore_week01.model;

import com.sparta_spring.sparta_springcore_week01.dto.ProductMypriceRequestDto;
import com.sparta_spring.sparta_springcore_week01.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends Timestamped {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    @Column(nullable = false)
    private Long userId;

    // 관심상품 생성 시 사용
    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.image = requestDto.getImage();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;

    }
    // 회원별로관신상품 생성 시
    public Product(ProductRequestDto requestDto,Long userid){
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.image = requestDto.getImage();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
        this.userId = userid; // 로그인한 회원 아이디로 저장

    }

    // 최저가격 업데이트
    public void updateMyPrice(ProductMypriceRequestDto requestDto){
        this.myprice = requestDto.getMyprice();
        return;
    }
}
