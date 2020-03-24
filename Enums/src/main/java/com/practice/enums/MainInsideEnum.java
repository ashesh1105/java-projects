package com.practice.enums;

/**
 * Every enum constant is always implicitly public static final. Since it is static, we can access it by using enum Name.
 * Since it is final, we can’t create child enums.
 * We can declare main() method inside enum. Hence we can invoke enum directly from the Command Prompt.
 */
enum MainInsideEnum {

    RED, GREEN, BLUE;

    // Driver method
    public static void main(String[] args) {
        MainInsideEnum c1 = MainInsideEnum.RED;
        System.out.println(c1);
    }

}
