package com.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class SplitTextMessageNumCharacterLimit {

	/*
	 * Given a text message and character limit per text message, split the text message to fit the rule.
	 * Example: text message: "Hi Sivasrinivas, your Uber is arriving now!", with char limit of 25 you should get:
	 * 3 text messages as: ["Hi Sivasrinivasa,(1/3)", "your Uber is arriving(2/3)", "now!(3/3)"]
	 */

	public static void main(String[] args) {

		String msg = "Hi Sivasrinivas, your Uber is arriving now!";
		int characterLimit = 20;

		List<String> result = new SplitTextMessageNumCharacterLimit().getMessagesPerCharacterLimit(msg, characterLimit);

		int index = 1;
		int size = result.size();
		System.out.print("[");
		for (String str : result) {
			if (index == size) {
				System.out.print("\"" + str + "(" + index++ + "/" + size + ")\"");
			} else {
				System.out.print("\"" + str + "(" + index++ + "/" + size + ")\", ");
			}
		}
		System.out.print("]");

	}

	public List<String> getMessagesPerCharacterLimit(String msg, int characterLimit) {

		// TBD: Do null and empty check for string and 0 / negative check for characterLimit

		List<String> result = new ArrayList<String>();

		int len = msg.length();
		int i = 0;
		
		// increment index by characterLimit, if space found, add the substring to result, else get back till space is found
		while (i < len) {
			
			int j = i;
			j += characterLimit;

			// Check if end of remaining of msg is less than size limit, add that to list in that case
			if (j >= len - 1) {
				result.add(msg.substring(i, len));
				break;
			}

			// If there is a space exactly at <size limit> character, add the substring to result, else move back to get to space
			if (msg.charAt(j) == ' ') {
				result.add(msg.substring(i, j));
				i = j + 1;
			} else {
				while (msg.charAt(j) != ' ' && j > i) {
					j--;
				}
				// What if j came back to i and no space found? Log an error message in that case and break from the loop!
				if (j == i) {
					// Move j forward till next space, get this big word to add it to error message
					while (msg.charAt(j) != ' ')
						j++;
					System.out.println("A word \"" + msg.substring(i, j) + "\" is more than " + characterLimit
							+ " characters long. Increase the character limit to proceed.");
					break;
				}
				// If all is well, add the next text message and increment i by j (+1 to skip space)
				result.add(msg.substring(i, j));
				i = j + 1;
			}

		}

		return result;
	}

}
