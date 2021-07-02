package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 컨트롤러 어노테이션은 자동으로 스프링 컨테이너에 스프링 빈으로 등록 됨
public class MemberController {

    //MemberService memberService = new MemberService(); // 이렇게 할 수 있지만 그러면 테스트 할 때 새로생성해서 서로다른 객체로 테스트가 될 수 있다.
    public final MemberService memberService;

    // 생성자에서 memberService 객체를 외부에서 쓰는 객체를 받아서 최신화
    @Autowired // 스프링 컨테이너에서 스프링 빈 끼리 연결
    public MemberController(MemberService memberService){
        this.memberService = memberService; //memberService 객체를 외부에서 쓰는 객체를 받아서 최신화
    }
}
