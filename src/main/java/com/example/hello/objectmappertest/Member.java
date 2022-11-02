package com.example.hello.objectmappertest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;


    public Member(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public Member(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    //TODO : objectMapper를 사용할 때 메서드 명에 get이 포함되어있지 않아야한다
    //public Member getDefaultMember(){
    public Member DefaultMember(){
        return new Member("default", 0, "010-1111-2222");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber + '\'' +
                '}';
    }
}
