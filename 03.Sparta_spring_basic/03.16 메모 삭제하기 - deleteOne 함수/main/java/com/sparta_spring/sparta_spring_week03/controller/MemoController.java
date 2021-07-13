package com.sparta_spring.sparta_spring_week03.controller;

import com.sparta_spring.sparta_spring_week03.domain.Memo;
import com.sparta_spring.sparta_spring_week03.domain.MemoRepository;
import com.sparta_spring.sparta_spring_week03.domain.MemoRequestDto;
import com.sparta_spring.sparta_spring_week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json 컨트롤러
@RequiredArgsConstructor // 의존주입 생성자 자동완성
public class MemoController {
    // 필요한 멤버변수
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // API 작성
    // POST
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto){//@RequestBody: RequestBody에에 있는 것을 넣어줘 요청
        Memo memo = new Memo(memoRequestDto); // 리파지토리 메서드에는 Memo 클래스를 넣어야 함
       return memoRepository.save(memo);
    }

    //GET
    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc(); // 수정된 시간 순으로 모두 조회
    }

    //UPDATE
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto memoRequestDto) {
        return memoService.update(id, memoRequestDto); // 서비스의 업데이트 메서드 이용   }
    }

    //DELETE
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id); // 리파지토리에서 삭제 // 리파지토리는 예외처리 자동해줌
        return id;
    }
}
