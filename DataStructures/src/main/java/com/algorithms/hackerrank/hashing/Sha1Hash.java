package com.algorithms.hackerrank.hashing;

import java.util.*;
import java.security.*;

/*
An example of how you can compute Sha-1 Hash using MessageDigest class
To run the file, just provide the string you want to hash via console.
 */

public class Sha1Hash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.reset();
        m.update(input.nextLine().getBytes());
        for (byte i : m.digest()) {
            System.out.print(String.format("%02x", i));
        }
        System.out.println();
    }
}
