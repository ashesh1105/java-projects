package main.java.com.string;

public class ReverseString {

	public static void main(String[] args) {

		String word = "abcde";
		System.out.println("Original string: " + word);
		System.out.println("Reversed string: " + new ReverseString().reverse2(word));

	}

	public String reverse(String word) {

		if (word == null || word.length() == 1) {
			System.out.println("String is null or has length of 1. Returning null.");
			return null;
		}

		int len = word.length();
		char[] arr = word.toCharArray();

		for (int i = 0, j = len - 1; i <= j; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		return new String(arr);

	}
	
	public String reverse2(String str) {
		
		String result = "";
		
		if (str.length() == 1) {
			return str;
		} else {
			return (reverse2(str.substring(1)) + str.charAt(0));
		} 
		
	}

}
