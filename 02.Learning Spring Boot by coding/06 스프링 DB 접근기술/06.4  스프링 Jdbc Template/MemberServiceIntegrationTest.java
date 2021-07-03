package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest // 테스트 관련 어노테이션
@Transactional //Transactional: 테스트가 끝나고 데이터베이스 초기화 해서 다음 사용때 중복 방지
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;



    // 회원가입 테스트
    @Test
    void join() {
        // given : 주어진 데이터
        Member member = new Member();
        member.setName("first");

        // when : 함수를 실행시킬 때
        Long saveId = memberService.join(member);

        //then : 그러면 결과 검사
        Assertions.assertThat(member.getId()).isEqualTo(saveId);


    }

    // 중복회원 예외 테스트
    @Test
    void 중복회원예외테스트(){
        // given
        // 중복된 이름 멤버 2개 생성
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        // 이름 중복된 메버 추가
        memberService.join(member1);

        // 예외처리 방법2 : 더 세련된 방법 근데 Assertions 임포트 때문에 좀 복잡
       /* IllegalStateException e =  org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 멤버 입니다.");

        */
        // 예외처리 방법1
        try { // 예외코드
            memberService.join(member2);// 이름 중복된 메버 추가
            //fail();
        } catch (IllegalStateException e){ // 예외처리코드
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 멤버 입니다."); // Memberservice 클래스에서 예외나면 throw로  IllegalStateException를 넘겨서 그안의 메시지가 같은지 검사
            // 예외클래스.getMessage() : 예외의 메시지 반환
        }

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}