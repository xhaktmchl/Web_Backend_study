package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 컨트롤러 어노테이션은 자동으로 스프링 컨테이너에 스프링 빈으로 등록 됨
public class MemberController {

    //MemberService memberService = new MemberService(); // 이렇게 할 수 있지만 그러면 테스트 할 때 새로생성해서 서로다른 객체로 테스트가 될 수 있다.
    public final MemberService memberService;

    // 생성자에서 memberService 객체를 외부에서 쓰는 객체를 받아서 최신화
    @Autowired // 스프링 컨테이너에서 스프링 빈 끼리 연결
    public MemberController(MemberService memberService){
        this.memberService = memberService; //memberService 객체를 외부에서 쓰는 객체를 받아서 최신화
    }

    //url에서 조회 /members/new 회원 등록 페이지 로 이동
    @GetMapping("/members/new") // /members/new주소에서  members/createMemberForm 반환 -> 템플릿으로 이동
    public String CreateForm(){
        return "members/createMemberForm";
    }

    //회원 컨트롤러에서 회원을 실제 등록하는 기능
    // /members/new    주소에서 form 형식의 정보가 post 될 때 사용
    // url을 통해 만들어진 것 전송
    @PostMapping("/members/new")
    public String create(MemberForm form){ // 스프링에서 웹 inupt택의 name 속성을 form에 바로 대입시킴
        Member member = new Member();
        member.setName(form.getName()); // 폼에서 이름 가져와서 멤버객체에 저장

        memberService.join(member); // 새로생성된 객체 멤버서비스 객체에 추가

        return "redirect:/"; // 홈화면으로 다시 연결
    }

    // 회원 조회 컨트롤러
    @GetMapping("/members")
    public String list(Model model){ // Model 객체는 컨트롤러의 메소드를 객체로 받는다.
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members); // addAttribute: Model 객체의 내장 메소드로 addAttribute() 웹 화면으로 전송
        // 키:"members" 으로 넘겨줌
        return "members/memberList"; // String 형으로 반환해서 템플릿에서members/memberList주소 웹 화면 파일 찾음

    }
}
