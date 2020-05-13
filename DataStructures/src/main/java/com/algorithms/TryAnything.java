package com.algorithms;

import java.util.*;

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

        sb.append(new String[]{"abc", "123", "def"}); // This will give you an object inside sb instead of strings
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

        System.out.println("-1 % 7: " + (-1 % 7));
        System.out.println("7 % 7: " + (7 % 7));

        // Try map.forEach
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 8);
        map.put("NodeJS", 6);
        map.put("Kafka", 6);
        map.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

        // Arrays.stream
        int[] arr1 = new int[]{100, 1000};
        Arrays.stream(arr1).forEach(elem -> {
            System.out.println(elem);
        });

        // Try available elements in a list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        // Very Important Finding about List!!!
        System.out.println("ArrayList size: " + list.size());
        list.remove(5);
        list.remove(3);
        System.out.println("ArrayList new size: " + list.size());
        System.out.println("List remaining elements after removing 5 and 3:");
        list.forEach(System.out::println);
        System.out.println("This means list.remove(element o) removes from index if only one int supplied");

        list.remove(new Integer(7));
        System.out.println("List remaining elements after removing 7 as Integer object:");
        list.forEach(System.out::println);

        // Now, if we grab by index
        System.out.println("list.get(3): " + list.get(3));    // should print 5

        // String compare
        String str2 = "geeks";
        String str3 = "get";
        System.out.println(str2 + " compared to " + str3 + " = " + str2.compareTo(str3));

        // Math.random()

        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() % 2 = " + Math.random() % 2);
        System.out.println("Math.random() % 2 == 0 ? " + (Math.random() % 2 == 0));

        System.out.println("Get large random number by: Math.abs(UUID.randomUUID().getMostSignificantBits()): "
                + Math.abs(UUID.randomUUID().getMostSignificantBits()));

        // Math.pi
        System.out.println("Math.PI: " + Math.PI);
        int r = 2;
        System.out.println("2 * Math.PI * r: " + 2 * Math.PI * r);

        


    }

}
