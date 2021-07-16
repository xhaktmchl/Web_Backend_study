package com.sparta_spring.sparta_spring_week04.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductMypriceRequestDto {
    // 최저가 등록시 필요한 매개체

    private int myprice;// 내가 설정한 최저가 변수
}
