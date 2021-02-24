package com.algorithms.string;

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
			// If next char is not in StringBuilder, append to it, else 'update' the StringBuilder
			int idx = sb.indexOf(tempStr);
			if (idx == -1) {
				sb.append(tempStr);
			} else {
				// Add to map if current size is greater than max size so far
				int tempLen = sb.length();
				if (tempLen > maxSubStringLength) {
					maxSubStringLength = tempLen;
				}
				// Do below only if you need to return the substring(s) as well and not if just the max length.
				List<String> list = map.getOrDefault(tempLen, new ArrayList<>());
				list.add(sb.toString());
				map.put(tempLen, list);

				// Now, we want to remove the chars from 0 to idx in current StringBuilder, then
				// append current char to it. This way to restart on next set of non-repeating chars
				sb.delete(0, idx+1);
				// With temp bucket clear from up to the duplicate character found,
				// don't forget to add the current char in temp before proceeding to next char
				sb.append(tempStr);
			}
		}

		return map.get(maxSubStringLength);
	}

}
