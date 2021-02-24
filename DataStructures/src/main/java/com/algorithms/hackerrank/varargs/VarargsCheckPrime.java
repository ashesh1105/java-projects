package com.algorithms.hackerrank.varargs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * Inputs needs to be of 5 lines and output will be of 4 lines, only prints prime numbers:
 *
 * Sample Input:
 * 2
 * 1
 * 3
 * 4
 * 5
 *
 * Sample Output:
 * 2
 * 2
 * 2 3
 * 2 3 5
 */

class Prime {

    // Notice varargs here!
    void checkPrime(int ...num) {

        // If arguments are prime, print them with a space between them
        String result = "";
        for (int n : num) {
            if (isPrime(n)) {
                result = result + n + " ";
            }
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length()-1);
        }
        System.out.println(result);
    }

    boolean isPrime(int n) {
        if (n != 1 && (n == 2 || n == 3 || (n * n - 1) % 24 == 0)) return true;
        else return false;
    }
}
public class VarargsCheckPrime {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
