package com.sparta_spring.sparta_springcore_week01.controller;

import com.sparta_spring.sparta_springcore_week01.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언
public class HomeController {

    @GetMapping("/") // 처음 입장 시 홈 화면
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        // Model 객체 : 스프링 부트에서 Model 객체의 여러 기능 이용
        model.addAttribute("username", userDetails.getUsername()); // 로그인 아이디 username 정보 index로넘겨줌
        return "index"; // index.html 파일을 찾아간다.
    }

    // 관리자용 상품 조회
    @Secured("ROLE_ADMIN") // 스프링 시큐리티 기능: ROLE_ADMIN 관리자 역할만 사용 가능
    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());// 로그인 아이디 username 정보 index로넘겨줌
        model.addAttribute("admin", true); // 관리자 정보 넘겨줌
        return "index";
    }
}
