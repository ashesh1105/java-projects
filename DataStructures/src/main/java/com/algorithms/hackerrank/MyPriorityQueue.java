package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * In computer science, a priority queue is an abstract data type which is like a regular queue, 
 * but where additionally each element has a "priority" associated with it. In a priority queue, an element 
 * with high priority is served before an element with low priority.
 * 
 * In this problem there are a number of students in a school who wait to be served. Two types of events, 
 * ENTER and SERVED, can take place which are described below.
	ENTER: A student with some priority enters the queue to be served.
	SERVED: The student with the highest priority is served (removed) from the queue.
 * A unique id is assigned to each student entering the queue. The queue serves the students based on the following 
 * criteria (priority criteria):
	The student having the highest Cumulative Grade Point Average (CGPA) is served first.
	Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
	Any students having the same CGPA and name will be served in ascending order of the id.
	
	Sample Input:
	12
	ENTER John 3.75 50
	ENTER Mark 3.8 24
	ENTER Shafaet 3.7 35
	SERVED
	SERVED
	ENTER Samiha 3.85 36
	SERVED
	ENTER Ashley 3.9 42
	ENTER Maria 3.6 46
	ENTER Anik 3.95 49
	ENTER Dan 3.95 50
	SERVED
	
	Output:
	Dan
	Ashley
	Shafaet
	Maria
	
	(Basically output will have the student names who could not be served in spite of all the events being SERVED)
 *
 */

public class MyPriorityQueue {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

}

class Student implements Comparable<Student> {
    
    private int id;
    private String name;
    private double CGPA;
    
    public Student(int id, String name, double CGPA) {
        this.id = id;
        this.name = name;
        this.CGPA = CGPA;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCGPA() {
        return this.CGPA;
    }
    
    public int compareTo(Student student) {
        if (this.CGPA > student.getCGPA()) return -1;
        else if (this.CGPA < student.getCGPA()) return 1;
        else if (this.name.compareToIgnoreCase(student.getName()) == 0) {
            if (this.id > student.getId()) return -1;
            else if (this.id < student.getId()) return 1;
            else return 0;
        } else return this.name.compareToIgnoreCase(student.getName());
    }
}

class Priorities {
    PriorityQueue<Student> queue = new PriorityQueue<>();
    
    public List<Student> getStudents(List<String> events) {
        
        List<Student> result = new ArrayList<>();
        
        for(String event : events) {
           String [] eventsArr = event.split(" ");
            if (eventsArr == null || eventsArr.length == 0) continue;
            if (eventsArr[0].equalsIgnoreCase("SERVED")) {
                // Take this student out of queue
                queue.poll();
            } else {
                // This means first argument is "ENTER". TODO: Check it to ensure!
                // Add this student
                queue.add(new Student(Integer.parseInt(eventsArr[3]), eventsArr[1], Double.parseDouble(eventsArr[2])));
            }
        }
        Student first = queue.poll();
        if (first == null) return result;
        else {
            while (first != null) {
                result.add(first);
                first = queue.poll();
            }
        }
        return result;
    }
}
