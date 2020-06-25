package com.practice.streamsAndLambda.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAsLambda<Student> {

    private List<Student> students;

    public ComparatorAsLambda() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Takes a comparator instance and sorts the list of students
    // Can be passed:
    // 1) Comparator.comparing(Student::getName())
    // 2) Comparator.comparing(Student::getRollNumber())
    // 3) Comparator.comparing(Student::getAge())
    // 4) Comparator.comparing(Student::getName()).reversed()   // For revered sorting
    // 5) Comparator.comparing(Student::getName()).reversed()
    // 6) Comparator.comparing(Student::getName).thenComparing(Student::getAge), etc.
    public void sortStudents(Comparator comparator) {
        Collections.sort(students, comparator);
    }

    public void printStudents() {
        students.forEach(student -> {
            System.out.println(student);
        });
    }
}
