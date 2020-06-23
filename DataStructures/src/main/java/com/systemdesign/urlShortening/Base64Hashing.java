package com.systemdesign.urlShortening;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Base 64 Hashing. Charset of a-zA-Z0-9 and two salt characters, say _ (underscore) and $ (dollar sign).
 * You can use BigInteger, so you can handle large numbers. But long allows handling 64 bit numbers, so we are good
 * with long too. Using long will help avoid extra overheads in dealing with BigInteger.
 *
 * How this code works?
 * 1) This code takes UniqueNumbers from UniqueIdGenerator singleton class.
 * 2) Initiates a thread pool with desired number of threads, to simulate the real life situation where unique ids
 *    will be needed anytime, sometimes several on them within same milliseconds.
 * 3) Threads run a job which is testEncodingAndDecoding where we:
 * 3a) Base 64 Hash the uniqueId by creating a map of 0-63 -> a-zA-Z0-9 and 2 more chars to make up for 64, i.e., _ & $
 * 3b) We use above map to hash the ID.
 * 3c) We use a reverse map of a-zA-Z0-9_$ -> 0-63 to convert the hash back original ID.
 * 4) We compute start and end times and print the time taken with thread id.
 *
 * As you can see from the output of this code:
 *
 * A) Unique IDs are generate correctly with sequence number being added for requests falling in same milliseconds
 *    and new series of sequence id for next milliseconds onwards.
 *
 * B) Most Important: Time taken is about 5 seconds for first time it takes about 5 seconds but then onwards, it takes
 * 1 or a fraction of a milliseconds!!
 *
 * Example Run time taken with 10 threads in the pool (time is in nano seconds):
 * Thread ID: 11 Done Generating Unique ID. Time taken: 5,015,203,190
 * Thread ID: 12 Done Generating Unique ID. Time taken: 5,014,156,922
 * Thread ID: 13 Done Generating Unique ID. Time taken: 5,015,523,893
 * Thread ID: 14 Done Generating Unique ID. Time taken: 5,014,306,548
 * Thread ID: 15 Done Generating Unique ID. Time taken: 5,015,175,482
 * Thread ID: 16 Done Generating Unique ID. Time taken: 5,014,649,937
 * Thread ID: 17 Done Generating Unique ID. Time taken: 5,015,157,603
 * Thread ID: 18 Done Generating Unique ID. Time taken: 5,015,569,954
 * Thread ID: 19 Done Generating Unique ID. Time taken: 5,015,422,042
 * Thread ID: 20 Done Generating Unique ID. Time taken: 5,015,188,259
 *
 */

public class Base64Hashing {

    public static void main(String[] args) {

        long base = 64;
        int numThreads = 10;

        ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);

        for (int i=0; i<numThreads; i++) {
            threadPool.submit(() -> {
                new Base64Hashing().testEncodingAndDecoding(base);
            });
        }

        threadPool.shutdown();

    }

    private synchronized void testEncodingAndDecoding(long base) {

        long id = Thread.currentThread().getId();
        long start = System.nanoTime();

        long decimal = UniqueIdGenerator.getInstance().getNextId();
        Base64Hashing base64Hashing = new Base64Hashing();

        // Test the encoding
        String encodedString = base64Hashing.encodeBase64(decimal, base);
        System.out.println("\nThread ID: " + id + " Decimal was: " + decimal);
        System.out.println("\nThread ID: " + id + " Base " + base + " encoded string is: " + encodedString);

        // Test the decoding
        long decodedDecimal = base64Hashing.decodeBase64ToDecimal(encodedString, base);
        System.out.println("\nThread ID: " + id + " Encoded chars were: " + encodedString);
        System.out.println("\nThread ID: " + id + " Decoded decimal, the original unique id, was: " + decodedDecimal);

        long end = System.nanoTime();

        System.out.println("\nThread ID: " + id + " Done Generating Unique ID. Time taken: " + (end - start));
    }

    public String encodeBase64(long decimal, long base) {

        Map<Long, Character> charSetMap = getCharSetMap();
//        BigInteger baseInBigInt = BigInteger.valueOf(base);
        String result = "";

        while (decimal != 0) {
            result = charSetMap.get(decimal % base) + result;
            decimal = decimal / base;
        }
        return result;
    }

    public long decodeBase64ToDecimal(String base64String, long base) {

        Map<Character, Long> reverseCharSetMap = getReverseCharSetMap();

        int len = base64String.length();
        long decodedDecimal = 0L;
        int index = 0;

        for (int i = len - 1; i >= 0; i--) {
            char ch = base64String.charAt(i);
            long value = reverseCharSetMap.get(ch);
            decodedDecimal += value * (long) Math.pow(base, index);
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
