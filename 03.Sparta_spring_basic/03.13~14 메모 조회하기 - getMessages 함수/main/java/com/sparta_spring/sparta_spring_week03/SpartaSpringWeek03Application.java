package com.sparta_spring.sparta_spring_week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 웹 자바스크립트에서 수정된 시각 감지해서 연결해줌
@SpringBootApplication
public class SpartaSpringWeek03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpringWeek03Application.class, args);
    }

}
