package com.sparta_spring.sparta_spring_week02_assingment.controller;

import com.sparta_spring.sparta_spring_week02_assingment.domain.Person;
import com.sparta_spring.sparta_spring_week02_assingment.domain.PersonRepository;
import com.sparta_spring.sparta_spring_week02_assingment.domain.PersonRequestDto;
import com.sparta_spring.sparta_spring_week02_assingment.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // DI 생성자
@RestController // json 컨트롤러
public class PersonController {
    // 멤버변수
    private final PersonRepository personRepository;
    private final PersonService personService;

    // POST 생성
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){ //requestDto 로 정보 받고
        Person person = new Person(requestDto); // Person 객체로 변환후
        return personRepository.save(person); // 리파지토리에 저장
    }

    // GET 조회
    @GetMapping("/api/persons")
    public List<Person> getPersons(){ // 모든 person 리스트로 반환
        return personRepository.findAll();
    }

    // PUT 업데이트
    @PutMapping("/api/persons/{id}") // {} :변수를 나타냄
    public Long updatePerson(@PathVariable Long id,@RequestBody PersonRequestDto requestDto){ // @PathVariable 변수 경로 지정,@RequestBody
        return personService.update(id,requestDto);
    }

    // DELETE 삭제
    @DeleteMapping("/api/persons/{id}")// {} :변수를 나타냄
    public Long deletePerson(@PathVariable Long id){ // @PathVariable 로 id경로설정
        personRepository.deleteById(id); // 삭제
        return id; // 삭제된 아이디 반환
    }
}
