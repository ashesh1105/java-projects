package com.algorithms.hackerrank.hashing;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class MD5Hash {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next(); // "MyPwd123";

        System.out.println(DigestUtils.md5Hex(input).toUpperCase());

    }

    public String getMDFHash(String input) {
        return DigestUtils.md5Hex(input).toUpperCase();
    }

}
