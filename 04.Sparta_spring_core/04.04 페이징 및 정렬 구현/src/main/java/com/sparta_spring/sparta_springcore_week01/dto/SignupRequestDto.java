package com.sparta_spring.sparta_springcore_week01.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false; // 관리자용인지
    private String adminToken = ""; // 관리자면 관리자용 번호호}
}