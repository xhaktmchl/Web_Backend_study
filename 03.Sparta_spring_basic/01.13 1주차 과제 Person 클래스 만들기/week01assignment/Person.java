package com.week01assignment.week01assignment;

public class Person {
    // 멤버변수
    private String name;
    private int age;
    private String job;

    // 생성자
    public void Person(){

    }

    // setter
    public void setName(String name){
        this.name = name;
    }
    public void  setAge(int age){
        this.age = age;
    }
    public void setJob(String job){
        this.job = job;
    }

    // Getter
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getJob(){
        return this.job;
    }

}
