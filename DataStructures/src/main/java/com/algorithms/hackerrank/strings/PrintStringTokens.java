package com.algorithms.hackerrank.strings;

/*
Given a string with alphanumeric and other characters, print number of tokens and then one token on each
line. A token in this case is consecutive set of alphabetic characters.
Hint: use String.split(regex) method.
 */

public class PrintStringTokens {

    public static void main(String[] args) {

        PrintStringTokens printStringTokens = new PrintStringTokens();

        String str1 = "He is a very very good boy, isn't he?";
        String str2 = "YES      leading spaces        are valid,    problemsetters are         evillllll";
        String str3 = "1";
        String str4 = "            ";

        printStringTokens.printAlphabaticTokens(str1);
        printStringTokens.printAlphabaticTokens(str2);
        printStringTokens.printAlphabaticTokens(str3);
        printStringTokens.printAlphabaticTokens(str4);

    }

    public void printAlphabaticTokens(String str) {

        String[] arr = str.split("[^a-zA-Z\\'\\,]+");
        System.out.println(arr.length);
        for (String s : arr) {
            System.out.println(s);
        }
    }

}


