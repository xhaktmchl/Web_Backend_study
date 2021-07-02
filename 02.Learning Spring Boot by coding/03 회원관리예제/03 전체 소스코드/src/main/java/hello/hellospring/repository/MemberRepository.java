package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 멤버 저장 기능 // Member치고 옵션중 선택해야 import 됨
    Optional<Member> findById(Long id); //  ID 조회 기능 // Optional은 null처리 기법
    Optional<Member> findByName(String name);// 이름 조회 기능 // Optional옵션에서 선택 안하면 import java.util.Optional; 안떠서 에러
    List<Member> findAll(); // List 옵션에서 선택 안하면import java.util.List; 안 생겨서 에러


}
