package com.sparta_spring.sparta_spring_week03.service;

import com.sparta_spring.sparta_spring_week03.domain.Memo;
import com.sparta_spring.sparta_spring_week03.domain.MemoRepository;
import com.sparta_spring.sparta_spring_week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 의존주입 생성자 자동완성
@Service // 스프링에게 서비스임을 알림
public class MemoService {

    // 멤버변수
    private final MemoRepository memoRepository; // 외부 의존주입

    // 업데이트 메서드
    @Transactional // 스프링에게 sql 연결된 것이라고 알림
    public Long update(Long id, MemoRequestDto memoRequestDto){
        Memo memo = memoRepository.findById(id).orElseThrow( // 리파지토리에서 찾고 없으면 예외처리
                () -> new NullPointerException("찾는 메모가 없습니다.")
        );

        memo.update(memoRequestDto);
        return id;
    }
}
