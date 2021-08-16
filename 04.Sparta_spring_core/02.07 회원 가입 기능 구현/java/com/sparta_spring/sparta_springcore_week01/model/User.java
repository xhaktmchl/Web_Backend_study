package com.sparta_spring.sparta_springcore_week01.model;

import com.sparta_spring.sparta_springcore_week01.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User extends Timestamped{

    public User(String username,String password,String email,UserRole role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    // 회원 아이디
    @Column(nullable = false)// 반드시 값을 가지도록 합니다.
    private String username;
    // 회원 비번
    @Column(nullable = false)
    private String password;
    // 회원 이메일
    @Column(nullable = false)
    private String email;
    // 일반사용자/ 관리자 선택
    // enum 클래스 사용  / 그냥 String 으로 해도 됨
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
