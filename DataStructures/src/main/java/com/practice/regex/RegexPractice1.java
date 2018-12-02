package com.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice1 {
	
	/**
	 * [A-Za-z0-9]{2,20} -> means look for any character A to Z, a to z or 0-9, min 2 chars, max 20 chars
	 * [^A-Z] -> a caret symbol will mean don't include results with char sequence that follows it
	 * \\s -> look for white space (specific to Java)
	 * \\S -> looking for things that are not white space
	 * \\w{2,20} -> words with any character ([A-Za-z0-9_], min length 2, max length 20
	 * \\d -> digits (number)
	 * \\D -> Not a digit or number
	 * {5} -> something appears exactly 5 times
	 * A[KZ]|C[AOT] -> two letter word, beginning with A, ending with K, Z or beginning with C, ending with A, O or T
	 * {5,} -> Minimum 5 and max can be anything
	 * + -> whatever precedes must occur 1 or more times
	 * ? -> 0 or 1 times
	 * . ^ * + ? {} [ ] \ | () -> These symbols must be preceded by a back slash (\)
	 * \\{{1,} -> Find one or more bracket symbol "{". You can also do (\\{{1,}) or "\\{+" (+ -> for 1 or more)
	 * . -> a dot means anything but a new line character
	 * \\w* -> Any type of character that appears 0 or more times
	 * \\w+@\\w+\\.(com|co\\.\\w{2}) -> My regex supporting emails like abc123@xyz.com or abc123@xyz.co.xx (like co.in) 
	 * [0-9]*\\-*\\(?\\d{3}\\)?\\s?\\-?\\d{3}\\-?\\d{4} -> My phone number searching regex
	 */ 

	public static void main(String[] args) {
		
		String input = " Ashesh Singh Age 45 lives in San Jose with zipcode as 95117 in CA, his office is at 95051 "
				+ "Ashesh's friends live in NC, AZ, AL, GA, etc. My email abc123@gmail.com, Solan's"
				+ " rahulsolan22@yahoo.com, VK's veekay2250@ibm.co.in. My friend's phone numbers could be:"
				+ "(408)907-6219 or 512-555-9876 or even 1-(465) 976-6534. At times this could even be 3456789876!"
				+ " We visit URLs like http://www.google.com, http://www.bbc.com, http://www.cnn.com/news or even"
				+ " http://www.indiatv.co.in";
		
		String strangeInput = " 1Z aaa **** *** {{{ {{ { (";
		
		String regex = "\\s[^4-5][A-Za-z0-9]{2,20}\\s{1,10}";
		
		System.out.println(regexChecker(regex, input));
		
		// You can get substring at start and end index returned by matcher to verify the result
		// System.out.println(input.substring(79, 84).trim());
		
		// Look for zipcodes, 5 digits each
		System.out.println("Look for zip codes:");
		String regex1 = "\\s\\d{5}";
		System.out.println(regexChecker(regex1, input));
		
		// Look for US States that begin with either A and end with K, L, R, or Z OR begin with
		// C and end with either A, O or T
		System.out.println("US States with either A, end with K, L, R, or Z OR begin with C and end with A, O or T:");
		String regex2 = "A[KLRZ]|C[AOT]";
		System.out.println(regexChecker(regex2, input));
		
		// Find one or more bracket symbols
		System.out.println("Find 1 or more bracket symbols:");
		String regex3 = "\\{+";
		System.out.println(regexChecker(regex3, strangeInput));
		
		// Find three or more of anything (except new line character)
		System.out.println("Find three or more of anything (except new line character):");
		String regex4 = ".{3}";
		System.out.println(regexChecker(regex4, strangeInput));
		
		// Find email addresses of form abc123@asdf.com
		System.out.println("Find email addresses:");
		String regexEmails = "\\w+@\\w+\\.(com|co\\.\\w{2})";
		// Note: Inside [ ] bracket, don't put a dot (.) at the end, compiler dosn't like it!
		// String regex5 = "[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A_Za-z]{2,4}";
		System.out.println(regexChecker(regexEmails, input));
		
		// Phone numbers of the form 1-(412)555-1212 or (412)555-1212 or 412-555-1212 or even 1234567890
		System.out.println("Find phone numbers:");
		String regexPhoneNo = "[0-9]*\\-*\\(?\\d{3}\\)?\\s?\\-?\\d{3}\\-?\\d{4}";
		// Note: Inside [ ] bracket, don't put a dot (.) at the end, compiler dosn't like it!
		// String regex5 = "[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A_Za-z]{2,4}";
		System.out.println(regexChecker(regexPhoneNo, input));
		
		// Look for URLs on raw text of a web page of form: http://www.abc.com or http://www.indiatv.co.in
		System.out.println("Find URLs:");
		String regexUrls = "http://www\\.\\w+\\.\\w+\\.?\\w+";
		// Note: Inside [ ] bracket, don't put a dot (.) at the end, compiler dosn't like it!
		// String regex5 = "[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A_Za-z]{2,4}";
		System.out.println(regexChecker(regexUrls, input));
		
		// Search and replace, say all spaces to a comma and then space
		System.out.println("Regex find and replace example:");
		System.out.println(regexReplace("Ashesh Solan VK Ajai KMT"));
	}

	private static String regexChecker(String regex, String input) {
		
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher(input);
		StringBuilder sb = new StringBuilder();
		
		// Find on Matcher returns a boolean confirming there's a result
		while (regexMatcher.find()) {
			// group() method returns the last match
			if (regexMatcher.group().length() != 0) {
				sb.append(regexMatcher.group().trim() + "\n");
				// start() and end() returns the beginning and end index of the matched string in original string
				sb.append("Start index: " + regexMatcher.start() + "\n");
				sb.append("End index: " + regexMatcher.end() + "\n");
			}
		}
		return sb.toString();
	}
	
	private static String regexReplace(String input) {
		
		Pattern pattern = Pattern.compile("\\s+");
		Matcher regexMatcher = pattern.matcher(input);
		return regexMatcher.replaceAll(", ");
		
	}

}
