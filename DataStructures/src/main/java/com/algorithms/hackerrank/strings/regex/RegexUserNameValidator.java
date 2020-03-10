package com.algorithms.hackerrank.strings.regex;

/*
Write a regex expression to validate username.

The username consists of 8 to 30 characters inclusive. If the username consists of less than 8 or greater than 30
characters, then it is an invalid username. The username can only contain alphanumeric characters and
underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters [a-z],
uppercase characters [A-Z], and digits [0-9].
The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or uppercase
character [A-Z].
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUserNameValidator {

    public static void main(String[] args) {

        String username1 = "Julia";
        String username2 = "Samantha";
        String username3 = "Samantha_21";
        String username4 = "1Samantha";
        String username5 = "Samantha?10_2A";

        String isValid = " is Valid";
        String isNotValid = " is not Valid!";

        RegexUserNameValidator validator = new RegexUserNameValidator();

        System.out.println("Username " + username1 + (validator.isValidUsername(username1) ? isValid : isNotValid));
        System.out.println("Username " + username2 + (validator.isValidUsername(username2) ? isValid : isNotValid));
        System.out.println("Username " + username3 + (validator.isValidUsername(username3) ? isValid : isNotValid));
        System.out.println("Username " + username4 + (validator.isValidUsername(username4) ? isValid : isNotValid));
        System.out.println("Username " + username5 + (validator.isValidUsername(username5) ? isValid : isNotValid));

    }

    public boolean isValidUsername(String username) {

        String regexUsername = "[a-zA-Z]{1}\\w{7,29}";

        Pattern pattern = Pattern.compile(regexUsername);
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }



}
