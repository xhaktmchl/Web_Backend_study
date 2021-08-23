package com.sparta_spring.sparta_springcore_week01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //?? 원래 req아닌가?
@AllArgsConstructor // ???
@Getter
public class ProductRequestDto {
    private String title;
    private String image;
    private String link;
    private int lprice;
}
