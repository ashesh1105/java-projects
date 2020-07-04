package com.algorithms.string;

public class Anagram3 {

    /**
     * The underlying theory here is that if hash of all the chars of one string is same as that of another one,
     * then they will have precisely same set of characters. Here, to keep it simple, I am just adding the ascii
     * values of the chars and comparing them.
     *
     * There's a built-in way of getting hashCode too. But unfortunately, hashcode for "abc" and "bac" are not same
     * Why? Because they are two different strings, so their hash codes need to be different :)
     * hash1 = str1.hashCode();
     * hash2 = str2.hashCode();
     *
     */

    public static void main(String[] args) {

        System.out.println(new Anagram3().isAnagram("daniel clowes", "enid coleslaw"));

        System.out.println(new Anagram3().isAnagram("abc", "cab"));

    }

    public boolean isAnagram(String str1, String str2) {

        int hash1 = 0;
        int hash2 = 0;

        for (int i = 0; i < str1.length(); i++) {
            hash1 += str1.charAt(i);
        }

        for (int i = 0; i < str2.length(); i++) {
            hash2 += str2.charAt(i);
        }

        return hash1 == hash2;
    }

}
