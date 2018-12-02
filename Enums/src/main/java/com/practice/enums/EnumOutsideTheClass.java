package com.practice.enums;

/**
 * First line inside enum should be list of constants and then other things like methods, variables and constructor.
 * According to Java naming conventions, it is recommended that we name constant with all capital letters
 *
 * Internally below enum Color is converted to
 * class Color
 * {
 *      public static final Color RED = new Color();
 *      public static final Color BLUE = new Color();
 *      public static final Color GREEN = new Color();
 * }
 * So every enum constant is a singleton instance. Best way to create a singleton object!
 *
 *
 */

enum Color {
    RED,
    BLUE,
    GREEN
}

public class EnumOutsideTheClass {

    public static void main(String[] args) {

        System.out.println("Enum constant: " + Color.RED);
        System.out.println("Enum constant: " + Color.BLUE);
        System.out.println("Enum constant: " + Color.GREEN);

    }

}
