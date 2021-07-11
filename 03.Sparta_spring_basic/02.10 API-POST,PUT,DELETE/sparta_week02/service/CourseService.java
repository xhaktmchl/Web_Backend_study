package com.sparta_spring.sparta_week02.service;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import com.sparta_spring.sparta_week02.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 생성자 di 주입 기능 포함 lombok
@Service // 스프링에게 서비스 클래스라고 알림
public class CourseService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시 , 값 바뀌지 않음
    private final CourseRepository courseRepository;

    /*// DI 의존 주입
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록 스프링에게 알림
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }*/

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDto requestDto){
        // id로 조회해서 찾은 다음
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        // 객체 업데이트
        course1.update(requestDto);
        return course1.getId(); // 업데이트된 객체 id 반환
    }


}
