package com.sparta_spring.sparta_week02.controller;

import com.sparta_spring.sparta_week02.domain.Course;
import com.sparta_spring.sparta_week02.domain.CourseRepository;
import com.sparta_spring.sparta_week02.domain.CourseRequestDto;
import com.sparta_spring.sparta_week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // DI 생성자 자동완성
@RestController // json 형식 컨트롤러
public class CourseController {
    // 멤버변수
    private final CourseRepository courseRepository;
    private final CourseService courseService;
    // DI 생성자 롬복으로 자동완성

    @PostMapping("/api/courses")// PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    public Course createCourse(@RequestBody CourseRequestDto requestDto){//@RequestBody: 대입될 데이터 명시
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        return courseRepository.save(course);// JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
    }

    // GET방식으로 웹에 반환
    @GetMapping("/api/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    // PUT 방식 업데이트
    @PutMapping("/api/courses/{id}") // {}는 변수를 의미
    public Long updateCourse(@PathVariable Long id,@RequestBody CourseRequestDto requestDto){ //@PathVariable: url변수로 대입,
        return courseService.update(id, requestDto);
    }

    // DELETE 방식 삭제
    @DeleteMapping("/api/courses/{id}") // 입력받은 id로 삭제
    public Long deleteCourse(@PathVariable Long id){ //@PathVariable
        courseRepository.deleteById(id);
        return id;
    }
}
