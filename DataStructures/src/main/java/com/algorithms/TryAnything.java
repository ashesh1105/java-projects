package com.algorithms;

public class TryAnything {

    public static void main(String[] args) {

        int[] arr = new int[256];
        String str = "abcdefg";

        char ch = str.charAt(0);
        int temp = arr[ch];
        System.out.println(temp);

        // Parse char to int



        StringBuilder sb = new StringBuilder();

        sb.append('c');
        sb.append('b');
        System.out.println("sb: " + sb.toString());
        sb.delete(0, sb.length());
        System.out.println("new sb: " + sb.toString());

        int a = 858;
        System.out.println("a as String: " + Integer.toString(a));

        // ToDO: Find ways to remove just the matching paranthesis pairs, not the content between them!
        String str1 = "[(5+6)*{6*7}}[(7+9)]{4+4}}]";
        String regex1 = "\\(.*?\\)|\\[.*?\\]|\\{.*?\\}";
        String regex2 = "\\(([\\w]+)\\)|\\{.*?\\}|\\[.*?\\]";
        String replaced = str1.replaceAll(regex2, "");
        System.out.println("input Vs replaced string:");
        System.out.println(str1);
        System.out.println(replaced);


    }

}
