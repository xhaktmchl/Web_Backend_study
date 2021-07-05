package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac04 {
    public static void main(String[] args){
        // 반복문
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");
        System.out.println(fruits);

        // 반복문으로 배열 원소 출력
        for(int i=0;i<fruits.size();i++){
            System.out.println(fruits.get(i));
        }

        // 클래스 이용
        Course course1 = new Course();
        course1.title = "spring1";
        course1.tutor = "남병관";
        System.out.println(course1.title);
        System.out.println(course1.tutor);

        // 클래스이용 인자사용
        Course course2 = new Course("스프링", "선생님", 20);
        System.out.println(course2.title);
        System.out.println(course2.tutor);
        System.out.println(course2.days);



    }

}
