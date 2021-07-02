package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 웹 주소에 / 들어오면 이 곳으로 매핑
    public String home(){
        return "home";
    }
}
