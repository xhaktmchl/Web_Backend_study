package com.sparta_spring.sparta_spring_week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // 의존주입 생성자
@Getter
public class MemoRequestDto {

    // 멤버 변수
    private String username;
    private String contents;



}
