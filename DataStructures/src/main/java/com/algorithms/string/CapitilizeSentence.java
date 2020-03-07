package main.java.com.string;

import org.apache.commons.lang3.text.WordUtils;

public class CapitilizeSentence {
	
	/**
	 * Capitalize a sentence by making first letter in each word capital letter
	 */

	public static void main(String[] args) {
		
		String str = "this is a great weather over here!     ";
		CapitilizeSentence capitilizeSentence = new CapitilizeSentence();
		System.out.println("Original String: " + str);
		System.out.println("Resulting String: " + capitilizeSentence.capitalizeMeAlternate4(str));
	}
	
	/**
	 * Below approach loses leading or trailing white spaces. Fix this!
	 * Also see the alternate solutions below
	 */
	private String capitalizeMe(String str) {
		String result = "";
		StringBuilder sb = new StringBuilder();
		String [] arr = str.split(" ");
		int len = arr.length;
		
		for (int i=0; i<len; i++) {
			String word = arr[i];
			int wordLen = word.length();
			  if (wordLen == 1) {
				  arr[i] = word.toUpperCase();
			  } else {
				arr[i] = Character.toUpperCase(word.charAt(0)) + word.substring(1);  
			  }
			  if (i == len-1) {
				  sb.append(arr[i]);
			  } else {
				  sb.append(arr[i] + " ");
			  }
		}
		return sb.toString();
	}

	private String capitalizeMeAlternate1(String str) {
		String result = " ";
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		int prevIndex = 0;
		
		for (int i=0; i<len; i++) {
			if (str.charAt(i) == ' ') {
				// Ignore if there are spaces at the end
				// Note** trim() done on multiple spaces results in a String with one space!
				if (str.substring(i, len).trim().equals(" ")) break;
				sb.append(str.substring(prevIndex, prevIndex + 1).toUpperCase());
				sb.append(str.substring(prevIndex + 1, i+1));
				prevIndex = i+1;
			}
		}
		result = sb.toString();
		return result;
	}
	
	/**
	 * Below approach loses leading or trailing white spaces. Fix this!
	 * Also see the alternate solutions below
	 */
	private String capitalizeMeAlternate3(String str) {
		String result = "";
		StringBuilder sb = new StringBuilder();
		String [] arr = str.split(" ");
		int len = arr.length;
		
		for (int i=0; i<len; i++) {
			/**
			 * Note: If we have words with mixed case letters like wOrD, we can use WordUtils.capitalizeFully method
			 * to convert it to only first letter capitalized
			 */
			String capitalizedWord = WordUtils.capitalize(arr[i]);
			
			if (i == len-1) {
			  sb.append(capitalizedWord);
			} else {
		      sb.append(capitalizedWord + " ");
			}
		}
		return sb.toString();
	}
	
	/**
	 * There can be a 4th solution to it. Most elegant in my view! You don't lose leading / trailing whitespaces here!
	 * a) Create a char array from string
	 * b) Capitalize the first element (if it is not a space)
	 * c) Iterate through the array from 2nd element, look for character for which there's space on its left of it
	 * d) Replace that element with its capitalized form
	 * e) Once all done, create a new String from resulting array as new String(arr) and return it
	 */
	private String capitalizeMeAlternate4(String str) {
		char [] arr = str.toCharArray();
		if (arr[0] != ' ') {
			arr[0] = Character.toUpperCase(arr[0]);
		}
		int len = arr.length;
		
		for (int i=1; i<len; i++) {
			char temp = arr[i];
			if (temp == ' ') continue;
			if (arr[i-1] == ' ') arr[i] = Character.toUpperCase(temp);
		}
		return new String(arr);
	}
	

}
