package main.java.com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubStringNoDups {

	/*
	 * Given a string, find the largest substrings which do not have duplicates Variation 1: Just find the
	 * length of largest substring with no duplicates.
	 */

	public static void main(String[] args) {

		String str = "abcabczdbbaccbabcdefbcdefbgmnoopqt";

		List<String> largestSubStrings = new LargestSubStringNoDups().getLargestSubStrings(str);

		System.out.println("SubString with no duplicate chars and of max length in string " + str
				+ (largestSubStrings.size() > 1 ? " are:" : " is:"));
		largestSubStrings.forEach(x -> System.out.println(x));

	}

	public List<String> getLargestSubStrings(String str) {

		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int len = str.length();
		StringBuilder sb = new StringBuilder();
		int maxSubStringLength = 0;

		for (int i = 0; i < len; i++) {
			String tempStr = str.substring(i, i + 1);
//			char ch = str.charAt(i);
//			Character.toString(ch);
			// We need String because indexOf method of StringBuilder takes a String and not char
			// Make sure to check for last index of string too (i != len-1) as condition to add temp to map
			if (sb.indexOf(tempStr) == -1) {
				sb.append(tempStr);
			} else {
				int tempLen = sb.length();
				if (tempLen > maxSubStringLength) {
					maxSubStringLength = tempLen;
				}
				// Do below if-else only if you need to return the max length substring and not if only max length is needed.
				if (map.containsKey(tempLen)) {
					map.get(tempLen).add(sb.toString());
				} else {
					List<String> newTempList = new ArrayList<String>();
					newTempList.add(sb.toString());
					map.put(tempLen, newTempList);
				}
				sb.delete(0, tempLen);
				// With temp bucket clear now, don't forget to add the current char in temp to start with
				sb.append(tempStr);
			}
		}

		return map.get(maxSubStringLength);
	}

}
