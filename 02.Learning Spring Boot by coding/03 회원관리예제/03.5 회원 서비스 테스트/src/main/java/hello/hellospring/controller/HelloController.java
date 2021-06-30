package hello.hellospring.controller;

import org.springframework.stereotype.Controller; // @Controller 코딩 시 자동 생성
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 스프링 생성자 검색해서 import 해야 함
public class HelloController {
    //
    @GetMapping("hello") // 웹에서 hello 글자 들어오면 클래서 자동 매핑되서 메서드 실행
    public String hello(Model model) { // 스피링이 모델을 생성해서 넣어줌
        model.addAttribute("data","hello!!"); // 모델의 data속성 에 hello!! 값 삽입
        return "hello"; // 반환문자로 viewresolver가 화면을 찾아서 처리 하고 http://localhost:8080/hello 사이트로 들어갈 수 있음
    }
    //2.2 mvc 와 템플릿 작동
    @GetMapping("hello-mvc") // 웹에서 http://localhost:8080/hello-mvc?name=이름값 치면 이 메소드 실행
    public String helloMvc(@RequestParam("name") String name,Model model) { // RequestParam 파라미터값 요청, ?name=이름값 웹 주소에 붙혀야 함
        model.addAttribute("name",name); // 입력받은 name 저장 model(name: name)
        return "hello-template"; // 메소드 실행되고 뷰 템플릿으로 반환 // 템플릿 이름과 같으면 됨
    }

    // 2.3 API 작동 : 템플릿 없이 컨트롤러에서 바로 출력
    @GetMapping("hello-string") // 컨트롤러 매핑
    @ResponseBody // 웹 Body에 바로 넣는 명령
    public String helloString(@RequestParam("name") String name) { // @RequestParam("name") 로 name입력 요청
        return "Hello"+ name; // @RequestParam로 받은 name을 붙혀 "Hello name" 반환 하고 웹에 바로 출력
    }


    //2.3 API 작동2 : 객체이용
    @GetMapping("hello-api") //  hello-api 컨트롤러 매핑
    @ResponseBody // // 웹 Body에 바로 넘기는 명령!!!
    // 객체
    public Hello helloApi(@RequestParam("name") String name) { // 공개자 반환형 객체명(인수) // http://localhost:8080/hello-api?name=choi
        // 객체 생성
        Hello hello = new Hello(); // 컨쉬엔 단축키: 마무리 ; 자동 온성

        // 메서드 호출
        hello.setName(name); // 입력받은 이름값 대입 메서드 호출
        return hello; // 객체 반환 => json 방식으로 반환 {"키":"값"} 형식

    }

    // 클래스 생성
    static class Hello { // static 클래스
        private String name; // 클래스 멤버변수

        //  메서드
        public String getName() { // 이름 출력
            return name;
        }
        public void setName(String name) {
            this.name = name; // 이름 입력

        }
    }

}
