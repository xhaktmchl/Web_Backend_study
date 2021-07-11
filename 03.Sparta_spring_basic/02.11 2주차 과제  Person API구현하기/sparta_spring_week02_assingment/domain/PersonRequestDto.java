package com.sparta_spring.sparta_spring_week02_assingment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // di 생성자,final변수에 작용 // 정보를 담는 매개체이므로 의존주입 되어얗 함
public class PersonRequestDto {
    private final String name;
    private final int age;
    private final String job;


}
