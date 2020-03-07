package main.java.com.algorithms.hackerrank.strings;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexIPValidation {

    public boolean matches(String input) {

        String regex = "[0-2]?[0-5]{1,2}\\.[0-2]?[1-5]{1,2}\\.[0-2]?[1-5]{1,2}\\.[0-2]?[1-5]{1,2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {

        String input = "23.45.12.56";

        boolean isMatch = new RegexIPValidation().matches(input);

        System.out.println(input + " is " + (isMatch ? "an IP": "not an IP"));

    }


}
