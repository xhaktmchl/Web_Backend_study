package com.sparta_spring.sparta_week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter // getter 알아서 자동완성
@Setter
@RequiredArgsConstructor // di 생성자
public class CourseRequestDto { //  데이터 업데이트 시 매개체 클래스 DTO
    // 멤버 변수만 지정
    private final String title;
    private final String tutor;
}

