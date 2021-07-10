package com.sparta_spring.sparta_week02;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import com.sparta_spring.sparta_week02.domain.CourseRequestDto;
import com.sparta_spring.sparta_week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // 생성일자 수정일자 반영 가능
@SpringBootApplication
public class SpartaWeek02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaWeek02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {

            // 테이블역할 객체 생성
            Course course1 = new Course("스프링 부트 수업1", "choi");
            courseRepository.save(course1); //jpa로 course1 객체 저장

            // 데이터 전부 조회하기
            // jpa로 저장되어있는 코스들 조회해서 리스트로 저장
            List<Course> courseList = courseRepository.findAll();
            // 리스트내의 코스들 출력
            for(int i=0;i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 하나 조회하기
            /*Course search_course = courseRepository.findById(1L).orElseThrow( // 1L: L은 Long 자료형 의미 // orElseThrow: null처리
                    () -> new NullPointerException("아이디가 존재하지 않습니다.")
            );*/

            // 업데이트 후 데이터 출력
            CourseRequestDto requestDto = new CourseRequestDto("스프링 수업2", "강사2");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            // 리스트내의 코스들 출력
            for(int i=0;i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 전부 삭제
            courseRepository.deleteAll();
            courseList = courseRepository.findAll();
            // 리스트내의 코스들 출력
            for(int i=0;i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

        };
    }
}
