package com.practice.enums;

/**
 * Enum and Constructor :
 * enum can contain constructor and it is executed separately for each enum constant at the time of enum class loading.
 * We can’t create enum objects explicitly and hence we can’t invoke enum constructor directly.
 * Constructors in Enums, if declared explicitly, must be private!
 *
 * Enum and Methods :
 * enum can contain concrete methods ONLY i.e. NOT any abstract methods allowed!
 */

enum MyHobbies {

    SINGING, GUITAR, CODING, MOVIES;

    // enum constructor called separately for each constant
    // constructors in enums, if declared explicitly, must not be public or protected
    // Using private keyword will be redundant here but we can do that
    MyHobbies() {
        System.out.println("Enum constructor was called for: " + this.toString());
    }

    // Only concrete (not abstract) methods allowed!
    public void hobbyInfo() {
        System.out.println("Universal Hobby");
    }
}

public class EnumsWithConstructorAndMethods {

    public static void main(String[] args) {
        MyHobbies hobbiesEnum = MyHobbies.SINGING;
        System.out.println("MyHobbies.SINGING: " + hobbiesEnum);
        System.out.print("Calling a method on an enum constant: ");
        hobbiesEnum.hobbyInfo();
    }
}
