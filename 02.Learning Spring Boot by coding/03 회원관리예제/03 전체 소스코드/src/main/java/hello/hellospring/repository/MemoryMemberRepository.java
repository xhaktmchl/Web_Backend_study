package hello.hellospring.repository;

import com.fasterxml.jackson.annotation.JsonGetter;
import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // 멤버 저장  // 멤버 컨트롤러가 스프링 컨테이너로 가져올 수 있다
public class MemoryMemberRepository implements MemberRepository{ // alt+엔터 옵션 단축키: 로 implemwnt method 하면 메서드 정의 자동완성

    private static Map<Long, Member> store = new HashMap<>(); // 자바 Map 인터페이스와 HashMap 클래스
    private static long sequence = 0L; // 키값을 0,1,2... 등으로 생성????

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 멤머 ID 저장
        store.put(member.getId(),member); // store 자료에 멤버 아이디와 멤버 객체 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // 아이디로 조회
        return Optional.ofNullable(store.get(id)); // map객체에서 id로 찾은 값 반환 // ofNullable하면 null값 반환되어 나와도 괜찮
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // Map 인터페이스 내장 메서드
                // values() 로 map 안의 숫자값 뽑고 stream() 인터페이스에서 filter()메서드이용해서 안의 람다식에 조건에 맞는것 필터링
                .filter(member -> member.getName().equals(name)) // filter 로멤버 돌린다?? //람다식 사용 // 입력된 이름과 같은지 비교
                .findAny(); // 어떤 것이라도 찾으면 반환???

        //= return store.values().stream().filter(member -> member.getName().equals(name)).findAny()
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //id랑 이름 포함한 모든 member 객체들을  ArrayList 로 반환
        // 리스트에 store의 value값인 member 들 반환???
    }

    // 메서드 실행되고 store 객체 클리어 해줘야 테스트 시 실행된 멤버 중복 방지
    public void clearStore(){
        store.clear(); // Map 클래스 속 멤버 모두 제거 내부메서드
    }
}
