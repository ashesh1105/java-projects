package com.datastructures.strings;

import com.algorithms.hackerrank.strings.LargestSmallestSubstringLexographicalOrder;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringAlgosTests {

    private LargestSmallestSubstringLexographicalOrder largestSmallestSubstringLexographicalOrder
            = new LargestSmallestSubstringLexographicalOrder();

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

}
