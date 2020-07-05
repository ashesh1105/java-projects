package com.algorithms.hackerrank.hashing;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Hash {

    public static void main(String[] args) {

        String input = "MyPwd123";

        System.out.println(DigestUtils.md5Hex(input).toUpperCase());

    }

    public String getMDFHash(String input) {
        return DigestUtils.md5Hex(input).toUpperCase();
    }

}
