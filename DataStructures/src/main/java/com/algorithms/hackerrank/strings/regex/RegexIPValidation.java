package com.algorithms.hackerrank.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Write a class which will contain a string pattern. You need to write a regular expression
and assign it to the pattern such that it can be used to validate an IP address. Use the following definition
of an IP address:

IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

Some valid IP address:
000.12.12.034
121.234.12.12
23.45.12.56

Some invalid IP address:
000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip

 */

public class RegexIPValidation {

    public boolean matches(String input) {

        // Note here, brackets () are necessary whenever we use OR (|) operator!

        String regex = "([0-9]{1,2}|0[0-9]{1,2}|1[0-9]{1,2}|2[0-4][0-9]|25[0-5])"
                + "\\.(0?[0-9]{1,2}|1[0-9]{1,2}|2[0-4][0-9]|25[0-5])"
                + "\\.(0?[0-9]{1,2}|1[0-9]{1,2}|2[0-4][0-9]|25[0-5])"
                + "\\.(0?[0-9]{1,2}|1[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {

        String input1 = "000.12.12.034";
        String input2 = "23.45.12.56";
        String input3 = "121.234.12.12";
        String input4 = "00.12.123.123123.123";
        String input5 = "122.23";
        String input6 = "22.33.11.55";
        String input7 = "000.00.01.19";
        String input8 = "99.99.99.99";

        String ipStr = "an IP";
        String noIP = "not an IP!";

        boolean isMatch1 = new RegexIPValidation().matches(input1);
        boolean isMatch2 = new RegexIPValidation().matches(input2);
        boolean isMatch3 = new RegexIPValidation().matches(input3);
        boolean isMatch4 = new RegexIPValidation().matches(input4);
        boolean isMatch5 = new RegexIPValidation().matches(input5);
        boolean isMatch6 = new RegexIPValidation().matches(input6);
        boolean isMatch7 = new RegexIPValidation().matches(input7);
        boolean isMatch8 = new RegexIPValidation().matches(input8);

        System.out.println(input1 + " is " + (isMatch1 ? ipStr : noIP));
        System.out.println(input2 + " is " + (isMatch2 ? ipStr : noIP));
        System.out.println(input3 + " is " + (isMatch3 ? ipStr : noIP));
        System.out.println(input4 + " is " + (isMatch4 ? ipStr : noIP));
        System.out.println(input5 + " is " + (isMatch5 ? ipStr : noIP));
        System.out.println(input6 + " is " + (isMatch6 ? ipStr : noIP));
        System.out.println(input7 + " is " + (isMatch7 ? ipStr : noIP));
        System.out.println(input8 + " is " + (isMatch8 ? ipStr : noIP));

    }


}
