package com.practice.streamsAndLambda.comparator;

import lombok.Getter;

public class Student {

    @Getter
    private int rollNumber;
    @Getter
    private String name;
    @Getter
    private int age;

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
