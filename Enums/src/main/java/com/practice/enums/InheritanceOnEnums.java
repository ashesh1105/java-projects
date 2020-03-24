package com.practice.enums;

import java.util.Arrays;

/**
 * All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot
 * extend anything else.
 *
 * toString() method is overridden in java.lang.Enum class,which returns enum constant name.
 *
 * enum can implement many interfaces.
 *
 * These methods are present inside java.lang.Enum:
 * 1) values() method can be used to return all values present inside enum.
 * 2) Order is important in enums. By using ordinal() method, each enum constant index can be found, just like array index.
 * 3) valueOf() method returns the enum constant of the specified string value, if exists.
 */

// Java program to demonstrate working of values(),
// ordinal() and valueOf()
enum ColorEnum
{
    RED, GREEN, BLUE;
}

public class InheritanceOnEnums {

    public static void main(String[] args) {

        // Calling values()
        ColorEnum arr[] = ColorEnum.values();

        // enum as streams
        Arrays.stream(arr)
                .forEach(col -> System.out.println(col
                        + " at index "
                        + col.ordinal()));

        // Using valueOf(). Returns an object of
        // Color with given constant.
        // Uncommenting second line causes exception
        // IllegalArgumentException since WHITE does not exist with Color enum
        System.out.println("Color.valueOf(\"RED\"): " + Color.valueOf("RED"));
        // System.out.println(Color.valueOf("WHITE"));
    }

}
