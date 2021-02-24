package com.practice.regex;

/**
From Hackerank challenge.
In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than
once, but retain the first occurrence of any case-insensitive repeated word. For example, the words love
is repeated in the sentence I love Love to To tO code. Can you complete the code in the editor so it will turn
I love Love to To tO code into I love to code?

Sample Input
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB

Sample Output:
Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab

 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String input = "Goodbye bye Bye world World wOrLD";

        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }

        // Prints the modified sentence.
        System.out.println(input);

    }


}
