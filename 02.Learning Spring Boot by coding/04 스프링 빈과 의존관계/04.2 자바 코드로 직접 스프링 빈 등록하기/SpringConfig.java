package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 04.2 직접 스프링 빈 등록을 위해  컨트롤러가 Configuration 어노테이션 참조 하고 @Bean
public class SpringConfig {

    // 회원 컨트롤러 -> memberService 연결
    @Bean // @Bean : 스프링 빈으로 등록하라!
    public MemberService memberService(){ //
        return new MemberService(memberRepository());
    }
    // memberService -> memberRepository 연결
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
