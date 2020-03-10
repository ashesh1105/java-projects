package com.algorithms.hackerrank.strings.regex;

/*

From an XML like file, given a line, extract the content between valid tags, if invalid tag, print invalid.

Examples:
Input:
<h1>Nayeem loves counseling</h1>
Output:
Nayeem loves counseling

Input:
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
Output:
Sanjay has no watch
So wait for a while

Input:
<SA premium>Imtiaz has a secret life</SA premium>
Output:
Imtiaz has a secret life

Input:
<Amee>safat codes like a ninja</amee>
Output:
Invalid

 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtractTagContents {

    public List<String> getValidTagContents(String input) {

        List<String> result = new ArrayList<>();
        boolean matchFound = false;

        /*
        Note: Below regex is the core of this solution!
        A bracket denotes a group, first bracket (.+) is group1 which means tag name (between < and >)
        Second group is ([^<]+) which is placed before </\\1> (meaning </ then content from group 1 (tag name)
        then a >). So, second group ([^<]+) means content between tags and we are ensuring no occurrences of <
        is present for a valid content.

        Beauty of defining groups (by brackets ()) is, we can then refer them and also use while loops to find them all!
         */
        String regex = "<(.+)>([^<]+)</\\1>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // This is where we say find all the matches
        while (matcher.find()) {
            // And we need second group, which is content basically, not tag name (which is first group)
            result.add(matcher.group(2));
            matchFound = true;
        }

        if (!matchFound) {
            result.add("Invalid");
        }

        return result;
    }

    public static void main(String[] args) {

        String input1 = "<h1>Nayeem loves counseling</h1>";
        String input2 = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String input3 = "<SA premium>Imtiaz has a secret life</SA premium>";
        String input4 = "<Amee>safat codes like a ninja</amee>";

        RegexExtractTagContents extractTagContents = new RegexExtractTagContents();

        List<String> contents1 = extractTagContents.getValidTagContents(input1);

        for (String content : contents1) {
            System.out.println(content);
        }

        List<String> contents2 = extractTagContents.getValidTagContents(input2);

        for (String content : contents2) {
            System.out.println(content);
        }

        List<String> contents3 = extractTagContents.getValidTagContents(input3);

        for (String content : contents3) {
            System.out.println(content);
        }

        List<String> contents4 = extractTagContents.getValidTagContents(input4);

        for (String content : contents4) {
            System.out.println(content);
        }

    }


}
