package com.practice.enums;

public class EnumInsideTheClass {

    enum Color {
        RED, BLUE, GREEN
    }

    public static void main(String[] args) {
        Color c = Color.GREEN;
        System.out.println("Enum constant: " + c);
    }

}
