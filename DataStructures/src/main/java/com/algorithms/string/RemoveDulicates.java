package main.java.com.string;

import org.apache.commons.lang3.StringUtils;

public class RemoveDulicates {

	public static void main(String[] args) {

		String str = "!aaaaabcdefghabcdefgh!";
		System.out.println("Original String: " + str);
		String result = new RemoveDulicates().removeDups(str);
		if (!StringUtils.equals(str, result)) {
			System.out.println("With duplicates removed, resulting string is: "
					+ result);
		}
	}

	public String removeDups(String str) {

		// If string is null, empty or has just one element, there is nothing to
		// do
		if (StringUtils.isEmpty(str) || str.length() == 1) {
			System.out
					.println("WARNING: String is null, empty or has just one element.");
			return str;
		}

		char[] arr = str.toCharArray();
		int len = arr.length;
		int tail = 1;
		for (int i = 1; i < len - 1; i++) {
			int j = 0;
			while (j < tail) {
				if (arr[i] == arr[j]) {
					break;
				}
				j++;
			}
			if (j == tail) {
				arr[tail] = arr[i];
				tail++;
			}
		}
		// valueOf function of String takes array, offset and count. tail
		// be one more than the last good element we need (due to last increment
		// of it), but since it starts from 0, count will still be tail
		return String.valueOf(arr, 0, tail);
	}

}
