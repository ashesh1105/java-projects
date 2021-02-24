package com.algorithms.hackerrank.varargs;

public class VarargsDemo {

    void printPrime(int ...num) {

        System.out.println(num.length);

        System.out.println("Passed arguments were:");
        for (int n : num) {
            System.out.println(n);
        }

    }

    public static void main(String[] args) {

        // Below will print 3
        new VarargsDemo().printPrime(2, 3, 5);

    }

}
