package main.java.com.algorithms.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Algos {

	public static void main(String[] args) {

		Algos algos = new Algos();

		int i = 6;
		System.out.println("Fibonacci of " + i + " is: " + algos.fibonacci(i));

		String word = "abcdefghijklmnopqrstuvwxyz";

		long start = System.nanoTime();
		System.out.println("\nReverse of string " + word + " is: "
				+ algos.reverse1(word));
		long end = System.nanoTime();
		System.out.println("Time taken by reverse1 algo: " + (end - start)
				+ " nano second.");

		long start1 = System.nanoTime();
		System.out.println("\nReverse of string " + word + " is: "
				+ algos.reverse2(word));
		long end1 = System.nanoTime();
		System.out.println("Time taken by reverse2 algo: " + (end1 - start1)
				+ " nano second.");

		long start3 = System.nanoTime();
		System.out.println("\nReverse of string " + word + " is: "
				+ algos.reverse3(word));
		long end3 = System.nanoTime();
		System.out.println("Time taken by reverse3 algo: " + (end3 - start3)
				+ " nano second.\n");

		// Find missing number on an array of 1 to 100 numbers randomly
		// distributed
		int[] data = new int[10];
		int len = data.length;
		for (int j = 0; j < len; j++) {
			data[j] = j + 1;
		}
		// Remove a number randomly
		int k = new Random().nextInt(10);
		data[k] = 0;

		System.out.println("Missing number at index " + k + ": "
				+ algos.findMissingNumber(data, 0, len - 1));

		/*
		 * Count occurrence of words in a string
		 */
		String data1 = "AA BB CC AA CC AA DD CC BB AA DD";
		System.out.println("String passed to count words: " + data1);
		System.out.println("Words count in string:");

		Map<String, Integer> map = algos.countWords(data1);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// Map treeMap = new TreeMap(Collections.reverseOrder());

		// Find occurrences of a substring inside a string
		String mainString = "manabcdmanmanefghijmanklmnopman";
		String subString = "man";
		System.out.println("Occurrences of subString " + subString
				+ " inside mainString " + mainString + ": "
				+ algos.findOccurences(mainString, subString));

		/*
		 * String to integer
		 */
		String str = "-987650043";
		System.out.println("\ninteger form of String " + str + " is: "
				+ algos.stringToInteger(str) + "\n");

		/*
		 * Write a program to shuffle a deck of 52 cards and shuffle them
		 * equally to 4 players. Please refer to class Card under same package
		 */
		Map<Integer, List<Card>> play = algos.shuffleAndDistributeCards(4);
		for (Integer player : play.keySet()) {
			System.out.println("\nPlayer " + player + " cards:");
			for (Card card : play.get(player)) {
				System.out.println(card);
			}
		}
	}

	/*
	 * 1) Fibonacci in Java: The input will be number n and the output should be
	 * sum for 0 to n. for example for n =4 the result should be 0+1+2+3+4 = 10
	 */
	public int fibonacci(int n) {

		if (n == 1)
			return 1;

		return n + fibonacci(n - 1);

	}

	// Reverse a string - method1
	public String reverse1(String word) {

		if (word == null || word.length() == 1) {
			return word;
		}

		char[] arr = word.toCharArray();
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		return String.valueOf(arr);
	}

	// Reverse a string - method2
	public String reverse2(String word) {

		if (word == null || word.length() == 1) {
			return word;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = word.length() - 1; i >= 0; i--) {
			sb.append(word.charAt(i));
		}

		return sb.toString();
	}

	// Reverse the String - method3 (recursive way!!!)
	public static String reverse3(String str) {

		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse3(str.substring(1)) + str.charAt(0);
	}

	/*
	 * 4) Find the missing number in Java You have an array of numbers from 1 to
	 * 100 (both inclusive). The size of the array is 100. The numbers are
	 * randomly added to the array, but there is one random empty slot in the
	 * array. What is the quickest way to find that slot as well as the number
	 * that should be put in the slot? Try it for practice. please suggest the
	 * answer . [Trick sum of n numbers is n*(n+1)/2]
	 */
	// TODO: Still need to find the index! Should we sort it with merge sort?
	public int findMissingNumber(int[] data, int start, int end) {

		// We know there will be 100 numbers
		int len = data.length;
		int maxNum = 10;
		int sumExpected = maxNum * (maxNum + 1) / 2;

		// Get the actual sum of numbers
		int sumActual = 0;
		for (int num : data) {
			sumActual += num;
		}

		// Get the missing number
		int missingNumber = sumExpected - sumActual;

		// Find the slot in array where this missing number exists
		return missingNumber;
	}

	/*
	 * Write a substring function in Java String test= "AA BB CC BB BB CC BB";
	 * String[]{"BB", "CC", "AA"} Result shd be BB=4; CC=2 and AA=1 Since B
	 * occurred 4 times C did 2 times and A only 1 time. This basic problem can
	 * be asked in different ways like, You have multiple words in new paper and
	 * find out the frequency of words in one page of news paper?
	 */
	public Map<String, Integer> countWords(String data) {

		Map<String, Integer> resultMap = new HashMap<String, Integer>();

		String[] dataArr = data.split(" ");

		for (String str : dataArr) {
			if (resultMap.containsKey(str)) {
				resultMap.put(str, resultMap.get(str) + 1);
			} else {
				resultMap.put(str, 1);
			}
		}

		/*
		 * If we need sorted map per occurrence of words, we can merge sort
		 * dataArr based on occurrence value in resultMap and then create a
		 * LinkedHashMap to return it
		 */

		return resultMap;
	}

	/*
	 * Find occurrences of a substring inside a string. indexOf(String
	 * subString, int index) on a string gives index at which subString appears
	 * again after the specified index. If there is no such occurrence, it
	 * returns -1. Similarly lastIndexOf(String subString) returns -1 if there
	 * is no occurrence of subString inside the main string at all.
	 */
	public int findOccurences(String mainString, String subString) {

		// If either of the strings are null, return 0
		if (mainString == null || subString == null) {
			return 0;
		}

		int count = 0;

		// Get the first occurrence of subString inside mainString
		// If this is -1, return 0, meaning no occurrence at all
		int index = mainString.indexOf(subString);
		if (index == -1) {
			return count;
		}

		// If first and last occurrences are same, return 1
		if (index == mainString.lastIndexOf(subString)) {
			count++;
			return count;
		}

		int len = mainString.length();

		// Iterate through occurrences of subString beginning from first
		// occurrence (above).
		while ((index < len) && (mainString.indexOf(subString, index) != -1)) {

			count++;

			// Get next occurrence of subString
			index = mainString.indexOf(subString, index);

			// Increment index by 1 so we can get to next occurrence during next
			// iteration
			index++;
		}
		return count;
	}

	/*
	 * Convert String = "98989" into an integer without using any library
	 * functions in java. Give fastest way to do it and explain why your method
	 * is best.
	 */
	public int stringToInteger(String str) {
		int result = 0;
		int asciiZero = 48;
		int asciiNine = 57;
		int multiplier = 1;
		int negativeAscii = '-';
		boolean isNumNegative = false;

		int len = str.length();

		for (int i = len - 1; i >= 0; i--) {

			char charAtPos = str.charAt(i);

			// Handle negative numbers in string
			if (i == 0 && charAtPos == negativeAscii) {
				isNumNegative = true;

			} else if (charAtPos > asciiNine || charAtPos < asciiZero) {

				// Log error message here, it must be a number!
				System.out.println("\nPlease enter numbers between 0 to 9");
				return -1;

			} else {

				result += (charAtPos - asciiZero) * multiplier;
				multiplier *= 10;
			}
		}
		if (isNumNegative) {
			result = 0 - result;
		}
		return result;
	}

	/*
	 * Write a program to shuffle a deck of 52 cards and shuffle them equally to
	 * n number of players. Please refer to class Card under same package
	 */

	public Map<Integer, List<Card>> shuffleAndDistributeCards(int numPlayers) {

		Map<Integer, List<Card>> map = new HashMap<Integer, List<Card>>();
		
		if (numPlayers == 0) {
			//Log error message and return empty map
			return map;
		}
		
		List<Card> newDeck = Card.newDeck();
		Random random = new Random();
		int numCardsInDeck = 52;
		
		// One card is given to each player in a round
		int rounds = numCardsInDeck / numPlayers;

		// Distribute the cards to each person
		for (int i = 0; i < rounds; i++) {

			for (int j = 1; j <= numPlayers; j++) {
				
				int k = random.nextInt(numCardsInDeck);
				
				if (!map.containsKey(j)) {
					map.put(j, new ArrayList<Card>());
				}
				map.get(j).add(newDeck.get(k));
				newDeck.remove(k);
				numCardsInDeck--;
			}
		}
		return map;
	}

}
