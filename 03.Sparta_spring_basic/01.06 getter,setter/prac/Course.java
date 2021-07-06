package com.sparta.week01.prac;

// 클래스
public class Course {
    // 멤버변수 선언
    // title, tutor, days 가 Course 라는 맥락 아래에서 의도가 분명히 드러나죠!
    private String title;
    private String tutor;
    private int days;

    // 디폴트 생성자
    // 이렇게 아무런 파라미터가 없는 생성자를 기본생성자 라고 부릅니다.
    public Course() {

    }
    // 인자받는 생성자
    public Course(String title, String tutor, int days) {
        // this 는 "이것" 이죠? 클래스 변수를 가리킵니다.
        this.title = title;
        this.tutor = tutor;
        this.days = days;
    }

    // setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setTutor(String tutor){
        this.tutor = tutor;
    }

    public void setDays(int days){
        this.days = days;
    }

    // Getter
    public String getTitle(){
        return this.title;
    }
    public String getTutor(){
        return this.tutor;
    }
    public int getDays(){
        return this.days;
    }
}