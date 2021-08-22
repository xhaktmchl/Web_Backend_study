package com.sparta_spring.sparta_springcore_week01.controller;

import com.sparta_spring.sparta_springcore_week01.dto.SignupRequestDto;
import com.sparta_spring.sparta_springcore_week01.model.User;
import com.sparta_spring.sparta_springcore_week01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    // 유저 서비스 의존주입
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login(){
        return "login"; // login 문자열 반환하면 스프링에서 loginlhtml 파일 찾아서 반환
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login"; //login 문자열 반환하면 스프링에서 login.lhtml 파일 찾아서 반환
    }

    // 회원 가입 페이지 가져오기
    @GetMapping("/user/signup")
    public String signup() {
        return "signup"; // signup 문자열 반환하면 스프링에서 signup.lhtml 파일 찾아서 반환
    }

    //회원 등록 api
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto){
        userService.registerUser(requestDto);
        return "redirect:/"; // root 디렉터리로 다시 이동
    }

    // 인가 기능 api
    // 일반회원이 관리자 페이지 접속 못함
    @GetMapping("/user/forbidden")
    public String forbidden(){
        return "forbidden"; // forbidden.html 페이지 반환
    }

    // 카카오 로그인 api
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code){
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);
        return "redirect:/";// root 디렉터리로 다시 이동
    }

}
