package com.algorithms.hackerrank.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 An example of using reflection to get methods in a given class.
 Note:
 Difference between getMethods and getDeclaredMethods of java.lang.reflect.Method is:
 - getMethods returns both the methods declared in the class and ones in super class (at least from Object class)
 - getDeclaredMethods returns only the methods declared in the given class, not ones in super class.
 Check more on this here: https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html
 */

public class ReflectionMethodNames {

    public static void main(String[] args){

        Class studentClass = Student.class;
//        Method[] methods = studentClass.getMethods();
        Method [] methods = studentClass.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();

        for(Method method : methods){
            methodList.add(method.getName());
        }

        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod() {  }

    // ......
    // ......
    // some more methods
    // ......
}
