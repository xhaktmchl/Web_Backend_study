package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration // 04.2 직접 스프링 빈 등록을 위해  컨트롤러가 Configuration 어노테이션 참조 하고 @Bean
public class SpringConfig {
    private DataSource dataSource;

    // 의존주입을 위해 연결
    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }


    // 회원 컨트롤러 -> memberService 연결
    @Bean // @Bean : 스프링 빈으로 등록하라!
    public MemberService memberService(){ //
        return new MemberService(memberRepository());
    }

    // memberService -> memberRepository 연결
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource); // 위에서 의존 주입해서
        return new JdbcTemplateMemberRepository(dataSource);
    }


}
