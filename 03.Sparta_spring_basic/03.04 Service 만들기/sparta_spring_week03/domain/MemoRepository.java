package com.sparta_spring.sparta_spring_week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findAllByOrderByModifiedAtDesc(); // 수정 날짜로 정렬된 조회
    // jpa 공식문서에 여러 jpa 기능  있음
}
