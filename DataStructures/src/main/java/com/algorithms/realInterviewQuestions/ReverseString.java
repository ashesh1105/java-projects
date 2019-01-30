package com.algorithms.realInterviewQuestions;
//Implement your solution using only classes from java.lang.  No additional imports are permitted.

public class ReverseString {

    private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private static final String EXPECTED_RESULT = ".auqila angam erolod te erobal tu tnudidicni ropmet domsuie od des ,tile gnicsipida rutetcesnoc ,tema tis rolod muspi meroL";

    public static void main(String[] args) throws Exception {
        //DO NOT EDIT THIS METHOD
        String reversed = reverse(INPUT_STRING);

        if (!EXPECTED_RESULT.equals(reversed)) {
            throw new Exception(String.format("\"%s\" != \"%s\"", reversed, EXPECTED_RESULT));
        }
        
        System.exit(0);
    }

    private static String reverse(String string) {
        //Sanitize the input
    	
    	
    	// Approach # 1: Read from the end and add to anther empty string to start with. Return the string.
    	// Big O will be O(n)
    	
    	// Approach # 2: Read from both ends and swap the characters
    	
    	char [] arr = string.toCharArray();
    	
    	int len = arr.length;
    	
    	int i=0, j=len-1;
    	
    	while (i < j) {
    		
    		// swap elements at i and j
    		char temp = arr[i];
    		arr[i] = arr[j];
    		arr[j] = temp;
    		i++;
    		j--;
    		
    	}
    	
    	return new String(arr);
    	
    }
}
