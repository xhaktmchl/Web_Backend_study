package com.sparta_spring.sparta_week02.controller;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // DI 생성자 자동완성
@RestController // json 형식 컨트롤러
public class CourseController {
    // 멤버변수
    private final CourseRepository courseRepository;

    // DI 생성자 롬복으로 자동완성

    // GET방식으로 웹에 반환
    @GetMapping("/api/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}
