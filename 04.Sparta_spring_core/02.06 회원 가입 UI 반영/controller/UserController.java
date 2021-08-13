package com.sparta_spring.sparta_springcore_week01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
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

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup"; // signup 문자열 반환하면 스프링에서 signup.lhtml 파일 찾아서 반환
    }
}
