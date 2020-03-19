package com.algorithms.hackerrank.priorityQueue;

//class Student implements Comparable<Student> {
public class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }
// You don't need below code since we define Comparator in line in Priorities class with Student class like POJO!
//    public int compareTo(Student student) {
//        if (this.CGPA > student.getCGPA()) return -1;
//        else if (this.CGPA < student.getCGPA()) return 1;
//        else if (this.name.compareToIgnoreCase(student.getName()) == 0) {
//            if (this.id > student.getId()) return -1;
//            else if (this.id < student.getId()) return 1;
//            else return 0;
//        } else return this.name.compareToIgnoreCase(student.getName());
//    }
}
