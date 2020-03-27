package com.algorithms.string;

public class DuplicateChecker {
    /**
     * This version assumes that the string is any general string (may contain
     * non-ascii chars) Time complexity is order of n squared. This method does
     * not take additional space.
     *
     * @param s
     * @return
     */
	public boolean hasDuplicateCharsTwoLoops(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return true;
			}
		}
		return false;
	}

    /**
     * This method assumes that only ASCII characters are present Given the
     * above condition, we can check in order of n time - O(n) But we need to
     * use additional memory space to keep track of the counter for each
     * character
     *
     * @param s
     * @return
     */
    public boolean hasDuplicateChars(String s) {
        // Standard ASCII (if you want to include extended ASCII, you may use a 256 length array
        boolean[] charSet = new boolean[128]; // additional memory
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet[c]) return true;
            charSet[c] = true;
        }
        return false;
    }

    /**
     * If it is OK to change the contents of the string, we can first sort it
     * using nlogn algorithm like MergeSort (will study later). And then go over
     * each character checking if the neighbours are identical.
     * So time complexity becomes O(nlogn + n) = O(nlogn)
     *
     * @param s
     * @return
     */
	public boolean hasDuplicateCharsSortedChars(String s) {
//		// first sort the string in nlogn time (get char array, sort them and get string back by new String(array)
//		// now assuming that string has its characters sorted

		// Input validations
		if (s == null) {
			// log error
		}
		if (s.length() == 1) {
			return false;
		} else if(s.charAt(0) == s.charAt(1)) {
			return true;
		}

		// Now check if any consecutive chars are same
		for (int i=1; i < s.length(); i++) { //
			if (s.charAt(i-1) == s.charAt(i))
				return true;
		}
		return false;
	}

	// Use this method, it is order of magnitude faster, even compared to ASCII array based method!
    public boolean hasDuplicateCharsTailBasedMethod(String str) {

        // Do null checks and see if string has just one character in it, log errors appropriately
        int len = str.length();
        char[] A = str.toCharArray();
        int tail = 1;
        for (int i = 1; i < len; i++) {
            int j = 0;
            while (j < tail) {
                if (A[j] == A[i]) {
                    return true;
                } else {
                    j++;
                }
            }
            if (j == tail) {
                tail++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Comparing two methods
        long start1 = System.nanoTime();
		DuplicateChecker dc = new DuplicateChecker();
		long end1 = System.nanoTime();
		System.out.println(dc.hasDuplicateChars("abcdefghijklmnopqrstuvwxyy") + " -- Time taken by ASCII array based method: "
				+ (end1 - start1));

		long start2 = System.nanoTime();
		long end2 = System.nanoTime();
		System.out.println(dc.hasDuplicateCharsTailBasedMethod("abcdefghijklmnopqrstuvwxyy")
				+ " -- Time taken by Tail based method: "
				+ (end2 - start2));

    }
}
