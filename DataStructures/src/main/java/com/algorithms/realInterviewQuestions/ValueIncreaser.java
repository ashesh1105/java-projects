package com.algorithms.realInterviewQuestions;
//TODO:  Is this class Thread Safe?  Why?  If not, make it Thread-Safe
public class ValueIncreaser {

    private int value = 0;

    /**
     * if newValue > old value, set new value
     * otherwise do nothing.
     * @param newValue
     */
    public void setValue(int newValue) {

            if (newValue > value) {
                value = newValue;
            }
    }

    /**
     * never returns a value less than a prior call to getValue()
     * @return
     */
    public int getValue() {
        return value;
    }

}