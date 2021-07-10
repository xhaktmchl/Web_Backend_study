package com.sparta_spring.sparta_week02.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // getter 만 정의 ,setter는 리파지토리에 기능 있음
    public Long getId(){
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }
    // 생성자
    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    // 업데이트
    // 업데이트는 중간에 이용하던 객체를 변경해야 하므로 객체 외부에서 받아서 사용
    public void update(Course course){
        this.title = course.title;
        this.tutor = course.tutor;
    }


}