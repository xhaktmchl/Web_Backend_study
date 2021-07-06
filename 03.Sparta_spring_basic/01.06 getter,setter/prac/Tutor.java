package com.sparta.week01.prac;

public class Tutor {

    // 멤버변수
    private String name;
    private int bio;

    // 디폴트 생성자
    public void Tutor(){

    }

    // 인자받는 생성자
    public void Tutor(String name, int bio){
        this.name = name;
        this.bio = bio;
    }

    // setter
    public void setName(String name){
        this.name = name;
    }
    public void setBio(int bio){
        this.bio = bio;
    }

    // getter
    public String getName(){
        return this.name;
    }
    public int getBio(){
        return this.bio;
    }
}
