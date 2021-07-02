package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 스프링 컨테이너에 Service스프링 빈으로 등록 => Service에선 비즈니스 로직 구현
public class MemberService { // 회원가입 서비스

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // 리파지토리 객체 생성
    private final MemberRepository memberRepository;
    // final methods 는 final 지시어를 통해 메소드 오버라이드를 제한

    @Autowired // 스프링이 MemberService에 memberRepository 연결
    // 생성자에서 외부에서 쓰던 객체를 사용하기 위해 최신화
    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }


    // 회원가입 메서드
    public Long join(Member member){
        // 회원 아이디 중복확인
        validateDuplicateMethod(member);
        // 새로운 멤버 리파지토리에 추가
        memberRepository.save(member);
        return member.getId(); // 회원 아이디 반환
    }
    // 회원 이름 중복검사 메서드
    private void validateDuplicateMethod(Member member){
        //방법1 :Optional 변수로 뽑은 다음 내장메서드 적용
        // findByName 반환형이 Optional이므로 Optional 변수
       /* Optional<Member> result =  memberRepository.findByName(member.getName()); // 회원가입하는 아이디로 기존 리파지ㅗ리에 있는지 검사
        result.ifPresent(member1 -> { // Optional.ifPresent(람다식) : Optional객체 안에 만약 존재하면 람다식 실행
            throw new IllegalStateException("이미 존재하는 멤버 입니다.");
            //throw : 예외를 강제로 발생
            //IllegalStateException:  메소드를 호출하기 위한 상태가 아닐 때
        });*/

        // 방법2: 변수에 따로 저장하지않고 바로 Optional 메서드 적용 // 이 방법 추천
        memberRepository.findByName(member.getName()) // 회원가입하는 아이디로 기존 리파지ㅗ리에 있는지 검사
        .ifPresent(member1 -> { // Optional.ifPresent(람다식) : Optional객체 안에 만약 존재하면 람다식 실행
            throw new IllegalStateException("이미 존재하는 멤버 입니다.");
            //throw : 예외를 강제로 발생
            //IllegalStateException:  메소드를 호출하기 위한 상태가 아닐 때
        });
    }

    //==============================================
    /**전체 회원 조회**/
    // 모든 멤버 추출
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 특정 멤버 id 검색으로 추출
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
