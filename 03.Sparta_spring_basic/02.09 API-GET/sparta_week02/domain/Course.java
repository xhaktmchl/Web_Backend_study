package com.sparta_spring.sparta_week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // getter 스프링 에서 자동 사용, lombok 라이브러리
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.id자동증가하면서 부여하기 위해 사용
    private Long id;

    //@Column : 열 임을 나타냄
    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;


    // 생성자
    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    // 업데이트
    // 업데이트는 중간에 이용하던 객체를 변경해야 하므로 객체 외부에서 받아서 사용
    public void update(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }


}