package com.practice.systemDesign.urlShortening;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Base 64 Hashing. Charset of a-zA-z0-9 and two salt characters, say _ (underscore) and $ (dollar sign).
 * Use BigInteger, so you can handle large numbers. Increment it each time so you get unique numbers.
 * If you need the hashed data as about 6-7 digits, then long will suffice. Just don't forget to add an 'L'
 * at the end to tell the compiler to not treat this as integer before assigning to long variable:
 * long x = 3123456789L;
 *
 * Using long will help avoid extra overheads in dealing with BigInteger.
 */

public class Base64Hashing {

    public static void main(String[] args) {

        // Do this outside of Hash Generator, so you get unique results each time
        String baseNumStr = "2000000000";
        BigInteger decimal = new BigInteger(baseNumStr);

        // Add one to this number inside of this program to return unique result
        decimal = decimal.add(BigInteger.ONE);

        // long decimal = 2045648798;
        long base = 64;

        Base64Hashing base64Hashing = new Base64Hashing();

        String encodedString = base64Hashing.encodeBase62(decimal, base);

        // Test the encoding
        System.out.println("Decimal was: " + decimal);
        System.out.println("Base " + base + " encoded string is: " + encodedString);

        BigInteger decodedDecimal = base64Hashing.decodeBase62ToDecimal(encodedString, base);

        // Test the decoding
        System.out.println("\nBase " + base + " encoded chars were: " + encodedString);
        System.out.println("Decoded decimal is: " + decodedDecimal);
    }

    public String encodeBase62(BigInteger decimal, long base) {

        Map<Long, Character> map = getCharSetMap();
        BigInteger baseInBigInt = BigInteger.valueOf(base);
        String result = "";

        while (decimal.compareTo(BigInteger.valueOf(0)) != 0) {
            result = map.get(decimal.remainder(baseInBigInt).longValue()) + result;
            decimal = decimal.divide(baseInBigInt);
        }
        return result;
    }

    public BigInteger decodeBase62ToDecimal(String base62Digits, long base) {

        Map<Character, Long> map = getReverseCharSetMap();

        int len = base62Digits.length();
        BigInteger decodedDecimal = BigInteger.ZERO;
        int index = 0;

        for (int i = len - 1; i >= 0; i--) {

            char ch = base62Digits.charAt(i);
            long value = map.get(ch);
            decodedDecimal = decodedDecimal.add(BigInteger.valueOf(value * (long) Math.pow(base, index)));
            index++;
        }
        return decodedDecimal;
    }

    private Map<Long, Character> getCharSetMap() {

        Map<Long, Character> map = new HashMap<>();
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$";
        populateMap(map, charSet);

        return map;
    }

    private static void populateMap(Map<Long, Character> map, String charSet) {

        long index = 0;

        for (char ch : charSet.toCharArray()) {
            map.put(index, ch);
            index++;
        }
    }

    private Map<Character, Long> getReverseCharSetMap() {

        Map<Character, Long> map = new HashMap<>();
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$";
        populateReverseMap(map, charSet);

        return map;
    }

    private void populateReverseMap(Map<Character, Long> map, String charSet) {

        long index = 0;

        for (char ch : charSet.toCharArray()) {
            map.put(ch, index);
            index++;
        }

    }

}
