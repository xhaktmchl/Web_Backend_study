package com.sparta_spring.sparta_week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 상속ㅇ로 jpa 사용 가능
public interface CourseRepository extends JpaRepository<Course,Long> {

}
