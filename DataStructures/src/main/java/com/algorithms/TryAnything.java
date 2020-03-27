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

        // Clear the StringBuilder
        sb.delete(0, sb.length());

        sb.append(new String [] {"abc", "123", "def"}); // This will give you an object inside sb instead of strings
        System.out.println("sb.toString:" + sb.toString());

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

        // Character.isAphabetic and Character.isDigit
        System.out.println("Character.isAlphabetic('*'): " + Character.isAlphabetic('*'));
        System.out.println("Character.isAlphabetic('d'): " + Character.isAlphabetic('d'));
        System.out.println("Character.isAlphabetic('['): " + Character.isAlphabetic('['));
        System.out.println("Character.isAlphabetic('R'): " + Character.isAlphabetic('R'));
        System.out.println("Character.isDigit('u'): " + Character.isDigit('u'));
        System.out.println("Character.isDigit('8'): " + Character.isDigit('8'));
        System.out.println("Character.isDigit('@'): " + Character.isDigit('@'));
        System.out.println("Character.isDigit('0'): " + Character.isDigit('0'));

        // All of below operations and more are available with Scanner instance to call on!
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
//        scanner.next();
//        scanner.nextDouble();
//        scanner.nextLong();

        char ch1 = '0';
        // Converting above char to a number, remember, Integer.parseInt() method takes a String, not char!
        // You need to first convert char to String by Character.toString(char), then use that
        System.out.println(Integer.parseInt(Character.toString(ch1)));

        // Or, you can always do it this way:
        System.out.println("char ch = '0' can be converted by doing subtracting 48 from it: " + (ch1 - 48));


    }

}
