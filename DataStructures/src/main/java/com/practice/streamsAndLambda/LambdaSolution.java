package com.practice.streamsAndLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Let's user Lambda expression to have a common way to compute isOdd, isPrime and isPalindrome functions!
In the input, first line will have integers that will denote number of test cases (lines, in our case). Next line on,
first char will be 1 (meaning Even/Odd check), 2 (meaning isPrime check), 3 (meaning isPalindrome check) needed for
the integer that comes up on same line space separated.

Input example:
5
1 4
2 5
3 898
1 3
2 12

Output example:
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
 */

// We have this as a functional interface here, with just one operation
interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Return an instance of PerformOperation with custom implementation
    public PerformOperation isOdd() {
        // Notice Lambda expression here
        // Instead of 2 commented lines below, you can simply do the uncommented one below them and it will infer!
        // PerformOperation po = (a) -> a % 2 != 0;    // brackets around a is not necessary since only one argument
        // return po;
        return (a) -> a % 2 != 0;

    }

    public PerformOperation isPrime() {
        // Lambda expression
        return (a) -> a > 1 && (a == 2 || a == 3 || (a * a - 1) % 24 == 0);
    }

    public PerformOperation isPalindrome() {
        // Lambda expression
        return (a) -> {
            String str = Integer.toString(a);
            char[] temp = str.toCharArray();
            for (int i = 0, j = temp.length - 1; i < j; i++, j--) {
                char ch = temp[i];
                temp[i] = temp[j];
                temp[j] = ch;
            }
            return str.equals(new String(temp));
        };
    }
}

public class LambdaSolution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        System.out.println(""); // Just to have a space after input in terminal
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

