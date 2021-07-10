package com.sparta_spring.sparta_week02.service;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 스프링에게 서비스 클래스라고 알림
public class CourseService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시 , 값 바뀌지 않음
    private final CourseRepository courseRepository;

    // DI 의존 주입
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록 스프링에게 알림
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Course course){
        // id로 조회해서 찾은 다음
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        // 객체 업데이트
        course1.update(course);
        return course1.getId(); // 업데이트된 객체 id 반환
    }
}
