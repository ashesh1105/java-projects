package com.datastructures.strings;

import com.algorithms.hackerrank.strings.LargestSmallestSubstringLexographicalOrder;
import com.practice.regex.RegexIPValidation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringAlgosTests {

    private LargestSmallestSubstringLexographicalOrder largestSmallestSubstringLexographicalOrder
            = new LargestSmallestSubstringLexographicalOrder();

    private RegexIPValidation regexIPValidation = new RegexIPValidation();

    @Test
    public void test_s_GreaterThan_k_LargestSmallestSubstringLexographicalOrder() {

        String result = largestSmallestSubstringLexographicalOrder
                .getLargestSmallestSubstringsLexicographicalOrder("welcomejava", 3);

        assertEquals("ava\nwel", result);
    }

    @Test
    public void test_s_GreaterThan_k_MixedCapsLargestSmallestSubstringLexographicalOrder() {

        String result = largestSmallestSubstringLexographicalOrder
                .getLargestSmallestSubstringsLexicographicalOrder("welcomeToJava", 3);

        assertEquals("Jav\nwel", result);
    }

    @Test
    public void test_s_LessThan_k_LargestSmallestSubstringLexographicalOrder() {

        String result = largestSmallestSubstringLexographicalOrder
                .getLargestSmallestSubstringsLexicographicalOrder("we", 3);

        assertNotEquals("ava\nwel", result);
        assertEquals("ERROR!", result);
    }

    @Test
    public void test_s_NullEmpty_Or_kZero_LargestSmallestSubstringLexographicalOrder() {

        String result1 = largestSmallestSubstringLexographicalOrder
                .getLargestSmallestSubstringsLexicographicalOrder(null, 3);

        String result2 = largestSmallestSubstringLexographicalOrder
                .getLargestSmallestSubstringsLexicographicalOrder("erty", 0);

        assertEquals("s sent as null, result should've been ERROR!", "ERROR!", result1);
        assertEquals("k sent as 0, result should've been ERROR!", "ERROR!", result2);
    }

    @Test
    public void test_AreValidIPs_RegexIPValidation() {

        // IPs strings to test
        String input1 = "000.12.12.034";
        String input2 = "23.45.12.56";
        String input3 = "121.234.12.12";
        String input4 = "00.12.123.123123.123";
        String input5 = "122.23";
        String input6 = "22.33.11.55";
        String input7 = "000.00.01.19";
        String input8 = "99.99.99.99";
        String input9 = "I.am.not.IP";

        // Positive tests
        Assert.assertTrue(regexIPValidation.matches(input1));
        Assert.assertTrue(regexIPValidation.matches(input2));
        Assert.assertTrue(regexIPValidation.matches(input3));
        Assert.assertTrue(regexIPValidation.matches(input6));
        Assert.assertTrue(regexIPValidation.matches(input7));
        Assert.assertTrue(regexIPValidation.matches(input8));

        // Negative tests
        Assert.assertFalse(regexIPValidation.matches(input4));
        Assert.assertFalse(regexIPValidation.matches(input5));
        Assert.assertFalse(regexIPValidation.matches(input9));
    }



}
