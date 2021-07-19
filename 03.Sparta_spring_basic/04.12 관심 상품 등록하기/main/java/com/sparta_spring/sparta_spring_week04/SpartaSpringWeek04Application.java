package com.sparta_spring.sparta_spring_week04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // jpa에서 타임스탬프 사용가능하게
@SpringBootApplication
public class SpartaSpringWeek04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpringWeek04Application.class, args);
    }

}
