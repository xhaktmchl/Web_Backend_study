package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    // 3.3 인터페이스를 구현한 클래스 메서드 테스트 하기
    // 테스트 케이스 모두 실행: 테스트 파일에서 run 해주면 해당 파일의 모두 실행
    //MemberRepository repository = new MemoryMemberRepository(); // 인터페이스자료형 변수에 인터페이스를 구현한 클래스 객체 생성
    MemoryMemberRepository repository = new MemoryMemberRepository(); // MemoryMemberRepository의 clearStore 메서드 쓰기위해 MemoryMemberRepository의객체로 변수생성

    @AfterEach // 각 메서드가 끝날 때 마다 실행 어노테이션 // 끝날 때 마다 repository 클리어 해줘야 연속 테스트시 멤버 중복 안됨
    public void afterEach(){
        repository.clearStore();
    }


    @Test // Test 어노테이션을 해야 함
    // save 기능 테스트
    public void saveTest(){ // save != 인터페이스 클래스의 save메서드
        Member member = new Member(); // 멤버 객체 생성
        member.setName("spring");

        repository.save(member); // 멤버의 id 생성및 저장 후 repository객체에 멤버 추가

        // 새로 저장한 멤버가 잘 저장 됬는지 확인
        Member result = repository.findById(member.getId()).get(); // repository 객체 멤버중 새로 저장한 멤버의 id를 가진 멤버 Optional 형에서 멤버 추출
        // get()은 findById 반환형이 Optional인데 이것의 멤버를 추출하는 방법

        // 멤버 일치하는지 확인
        System.out.println("result ="+(result == member)); // 방법 1
        //Assertions.assertEquals(member,result); // 방법2 // Assertions.assertEquals(실제 값,예상 값); : 똑같은지 반
        Assertions.assertThat(member).isEqualTo(result); // 방법3 // assertThat(실제값)이 isEqualsTo(기대값)과 같냐 // 보통 이 방법 추천
        // import 파일이 다른데 겹쳐서 assertEquals나 assertThat 중 하나의 Assertions파일만  import 해서 써야 함
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result); // 2,3방법 둘 다 사용알 때 직접 임포트 방법으로 해야 함

    }

    // 아이디로 조회기능 테스트
    @Test
    public void findByNameTest(){
        // 리파지토리에 저장할  멤버객체 생성
        Member member1 = new Member();
        member1.setName("spring1"); // 이름 설정 // id는 repository.save 메서드에서 자동 부여되므로 안함
        repository.save(member1);   // 리파지토리에 멤버 추가
        Member member2 = new Member();
        member2.setName("spring2"); // 이름 설정
        repository.save(member2);

        // 이름 잘 조회되는지 검사
        // findByName 이 Optional 반환형이므로 Optional<Member>의 내장 메서드 get()을 하면 속의 객체 가져옴
        Member result = repository.findByName(member1.getName()).get(); // member1의 이름으로 검색된 멤버객체 추출

        // 이름잘 검색됬는지 검사
        System.out.println("resultName = "+(result == member1)); // 방법1
        Assertions.assertThat(member1).isEqualTo(result); // 방법2

    }

    // findAll 기능 테스트
    @Test
    public void findAllTest(){
        // 리파지토리에 멤버 생성및 저장
        // 멤버1 생성 및 리파지토리에 추가
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        // 멤버2 생성 및 리파지토리에 추가
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //리파지토리에서 모든 멤버 잘 찾아지는지 테스트
        List<Member> result = repository.findAll(); // 리파지토리에서 모든 멤버 찾아서 list형으로 저장
        Assertions.assertThat(result.size()).isEqualTo(2); // result의 멤버들의 수가 맞는지 확인

    }

}
