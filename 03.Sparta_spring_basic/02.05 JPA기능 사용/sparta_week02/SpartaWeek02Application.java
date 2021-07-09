package com.sparta_spring.sparta_week02;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpartaWeek02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaWeek02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {

            // 테이블역할 객체 생성
            Course course1 = new Course("스프링 부트 수업1","choi");
            repository.save(course1); //jpa로 course1 객체 저장

            // jpa로 저장되어있는 코스들 조회해서 리스트로 저장
            List<Course> courseList = repository.findAll();
            // 리스트내의 코스들 출력
            for(int i=0;i<courseList.size();i++){
                Course c = courseList.get(i);
                System.out.println(c);
                System.out.println(c.getTitle()); // Course 에서 정의한 getter
                System.out.println(c.getTutor()); // Course 에서 정의한 getter
            }

        };
    }
}
