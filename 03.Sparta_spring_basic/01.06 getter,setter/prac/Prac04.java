package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac04 {
    public static void main(String[] args){

        // 클래스 이용
        Course course1 = new Course();
        // setter를 이용한 설정
        course1.setTitle("spring1");
        course1.setTutor("남병관");
        course1.setDays(12);
        // getter 이용한 참조
        System.out.println(course1.getTitle());
        System.out.println(course1.getTutor());
        System.out.println(course1.getDays());
        // 클래스이용 인자사용
        Course course2 = new Course("스프링", "선생님", 20);
        System.out.println(course2.getTitle());
        System.out.println(course2.getTutor());
        System.out.println(course2.getDays());



    }

}
