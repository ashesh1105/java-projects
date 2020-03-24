package com.practice.enums;

import java.util.Arrays;

/**
 * By default enums have their own string values, we can also assign some custom values to enums. Consider below example for that.
 *
 * Examples:
 * enum  Fruits
 * {
 *     APPLE(“RED”), BANANA(“YELLOW”), GRAPES(“GREEN”);
 * }
 *
 * In above example we can see that the Fruits enum have three members i.e APPLE, BANANA and GRAPES which have their own
 * different custom values RED, YELLOW and GREEN respectively.
 *
 * Now to use this enum in code, there are some rules we have to follow:-
 * We have to create parameterized constructor for this enum class. Why? Because as we know that enum class’s object
 * can’t be created explicitly so for initializing we use parameterized constructor. And the constructor cannot be the
 * public or protected it must have private or default modifiers. Why? if we create public or protected, it will allow
 * initializing more than one objects. This is totally against enum concept.
 *
 * We have to create one getter method to get the value of enums.
 */

enum EnumWithCustomValues {

    // This will call enum constructor with one String argument
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");

    // declaring private variable for getting values
    private String action;

    // enum constructor - cannot be public or protected!
    EnumWithCustomValues(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static void main(String[] args) {

        EnumWithCustomValues arr[] = EnumWithCustomValues.values(); // <enum_class_name>.values() is built-in method!

        Arrays.stream(arr)
                .forEach(enumVal -> {
                    System.out.println(
                        "name: " + enumVal.name() + // <enum_constants>.name() is built-in method, although not needed here
                                " action: " + enumVal.getAction()
                    );
                });
    }
}
