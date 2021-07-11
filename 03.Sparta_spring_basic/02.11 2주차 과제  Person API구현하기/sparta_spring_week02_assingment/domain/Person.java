package com.sparta_spring.sparta_spring_week02_assingment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor // 빈 생성자
@Entity // sql의 테이블 나타냄
public class Person {
    // 멤버변수
    // id부여
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //  열 항목
    @Column(nullable = false) // null 허용 않됨
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    // 컨트롤러에서 필요한 생성자
    public Person(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }

    // 업데이트 메서드
    public void update(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }










}
