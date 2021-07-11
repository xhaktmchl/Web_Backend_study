package com.week01assignment.week01assignment.controller;

import com.week01assignment.week01assignment.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    // 웹에 get방식으로 전달
    @GetMapping("/myinfo")
    public Person getPersons(){ // Person 객체 정보 세팅해서 반환
        Person person = new Person();
        person.setName("Choi");
        person.setAge(24);
        person.setJob("student");

        return person;
    }

}
