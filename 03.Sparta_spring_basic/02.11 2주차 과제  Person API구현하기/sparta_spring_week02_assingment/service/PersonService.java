package com.sparta_spring.sparta_spring_week02_assingment.service;

import com.sparta_spring.sparta_spring_week02_assingment.domain.Person;
import com.sparta_spring.sparta_spring_week02_assingment.domain.PersonRepository;
import com.sparta_spring.sparta_spring_week02_assingment.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // di 생성자
@Service
public class PersonService {
    private final PersonRepository personRepository; // 사용하던 personRepository 의존주입

    @Transactional // Service에서 sql과 연결
    public Long update(Long id, PersonRequestDto personRequestDto){
        Person person1 = personRepository.findById(id).orElseThrow( // 리파지토리에서 id로 겁색하고 없으면 예외발생
                () -> new NullPointerException("찾는 아이디가 없습니다.")
        );

        person1.update(personRequestDto); // person 정보 업데이트
        return person1.getId();


    }


}
