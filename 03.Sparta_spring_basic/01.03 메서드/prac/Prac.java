package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {
    // 메서드 정의
    // public, static void 에 대해서는 곧 배웁니다! 우선은 넘어갈게요.
    public static void printInfo() {
        String title = "웹개발의 봄 Spring";
        String tutor = "남병관";
        int weeks = 5;
        float ratings = 5.0f;

        System.out.println("제목: " + title);
        System.out.println("튜터: " + tutor);
        System.out.println("주차: " + weeks);
        System.out.println("별점: " + ratings);
    }

    // 메서드 인자와 반환
    // 파라미터 X, 반환값 X
    public static void simplePrint() { // static: 메인함수 안에서 메서드를 사용하기 위해 사용
        System.out.println("파라미터도 없고, 반환값도 없어요!");
    }

    // 파라미터 O, 반환값 X
    public static void simpleSum(int num1, int num2) {
        System.out.println("num1 :" + num1 + ", num2: " + num2);
    }

    // 파라미터 X, 반환값 O
    public static int simpleReturn() {
        return 3;
    }

    // 파라미터 O, 반환값 O
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    //
    public static int minus(int a,int b){
        return a-b;
    }

    public static void main(String[] args ){
       int a=0;
       int b=1;
       boolean isSame = a == b; // 부울 자료형
        System.out.println(isSame);


        // List
        String course1  = "웹개발 종합반";
        String course2  = "앱개발 종합반";
        List<String> newList = new ArrayList<>();
        newList.add(course1 ); // 추가
        newList.add(course2 );
        System.out.println(newList);
        System.out.println(newList.get(1)); // List.get(인덱스) : 참조
        newList.remove(0); // 삭제
        System.out.println(newList);


        // 주석
        // 단축키: 윈도우: Ctrl + /


        // 메서드
        printInfo();
        // 메서드 인자와 반환 형태
        simplePrint();
        simpleSum(1,2);
        simpleReturn();
        sum(1,2);

        // 메서드 퀴즈
        System.out.println(minus(1,2));
    }
}
