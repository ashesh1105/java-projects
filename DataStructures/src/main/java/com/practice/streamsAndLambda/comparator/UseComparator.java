package com.practice.streamsAndLambda.comparator;

import java.util.Comparator;

/**
 * This package demonstrates usage of Comparator as Lambda. We define list of Students in a class ComparatorAsLambda
 * class and also provide there a sort method that takes a Comparator instance. That way, a client can
 * sort the list the way (s)he needs it without accessing the list itself (immutable). sort method can take
 * following:
 * 1) Comparator.comparing(Student::getName())
 * 2) Comparator.comparing(Student::getRollNumber())
 * 3) Comparator.comparing(Student::getAge())
 * 4) Comparator.comparing(Student::getName()).reversed()   // For revered sorting
 * 5) Comparator.comparing(Student::getName()).reversed()
 * 6) Comparator.comparing(Student::getName).thenComparing(Student::getAge), etc.
 */

public class UseComparator {

    public static void main(String[] args) {

        ComparatorAsLambda<Student> comparatorAsLambda = new ComparatorAsLambda<>();

        // Add some students
        comparatorAsLambda.addStudent(new Student(103, "Ashley", 47));
        comparatorAsLambda.addStudent(new Student(101, "David", 25));
        comparatorAsLambda.addStudent(new Student(104, "Mohan", 21));
        comparatorAsLambda.addStudent(new Student(102, "John", 45));
        comparatorAsLambda.addStudent(new Student(105, "Don", 37));
        comparatorAsLambda.addStudent(new Student(106, "Ashley", 45));

        // Sort by First Name
        System.out.println("Students ordered by their first name:");
        comparatorAsLambda.sortStudents(Comparator.comparing(Student::getName));
        comparatorAsLambda.printStudents();

        // Sort by Roll Number
        System.out.println("\nStudents ordered by their roll number:");
        comparatorAsLambda.sortStudents(Comparator.comparing(Student::getRollNumber));
        comparatorAsLambda.printStudents();

        // Reverse sorting
        System.out.println("\nStudents in reverse ordered by their first name:");
        comparatorAsLambda.sortStudents(Comparator.comparing(Student::getName).reversed());
        comparatorAsLambda.printStudents();

        // Reverse Sorting
        System.out.println("\nStudents in reverse ordered by their age:");
        comparatorAsLambda.sortStudents(Comparator.comparing(Student::getAge).reversed());
        comparatorAsLambda.printStudents();

        // Sort by Name and within that sort by age. .thenComparing example
        System.out.println("\nStudents ordered by their first name and then age:");
        comparatorAsLambda.sortStudents(Comparator.comparing(Student::getName)
                .thenComparing(Student::getAge));
        comparatorAsLambda.printStudents();



    }

}
