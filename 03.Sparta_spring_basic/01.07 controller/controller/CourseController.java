package com.sparta.week01.controller;

import com.sparta.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json 형식 받는 어노테이션
public class CourseController {

    // 웹으로 바로 출력
    @GetMapping("/courses") // 웹의 get방식으로 courses 입력받으면
    public Course getCourses(){
        Course course = new Course();
        course.setTitle("스프링 수업");
        course.setTutor("강사1");
        course.setDays(35);
        return course;// course 객체 반환
    }
}
