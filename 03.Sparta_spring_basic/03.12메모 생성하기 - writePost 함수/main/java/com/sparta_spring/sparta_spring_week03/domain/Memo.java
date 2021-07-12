package com.sparta_spring.sparta_spring_week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 빈생성자
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped{

    // 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 열
    // 사용자 이름
    @Column(nullable = false)
    private String username;
    // 메모 내용
    @Column(nullable = false)
    private String contents;

    // 생성자
    // 유저이름, 메모내용으로 생성자
    public Memo(String username,String contents){
        this.username = username;
        this.contents = contents;
    }

    // DTO를 이용해서 생성
    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    // 업데이트 메서드
    public void update(MemoRequestDto memoRequestDto){
        this.username = memoRequestDto.getUsername();
        this.contents = memoRequestDto.getContents();
    }

}
