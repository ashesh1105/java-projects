package com.algorithms.hackerrank.inheritance;

/**
 * This demos how we can call and typecast a class inside a static class inside an outer class
 */

public class StaticInnerClassDemo {

    public static void main(String[] args) {

        // Notice how we access a class inside static inner call. No need to reference with StaticInnerClassDemo since we're
        // inside it already!
        Inner.NotPrivate notPrivate = new Inner().new NotPrivate();
        notPrivate.someMethod();

        int num = 8;

        // Same will apply for private classes inside static inner class too
        Inner.Private p = new Inner().new Private();
        System.out.println(num + " is " + p.powerof2(num));

        // However when you have to typecast a class inside static inner class, you'll need outer class!
        Object obj = new Inner().new Private();

        // Now, you can not call powerof2() on obj directly, you'll have to typecast it!
        System.out.println(num + " is " + ((StaticInnerClassDemo.Inner.Private)obj).powerof2(num));

    }

    static class Inner {

        private class Private {

            private String powerof2(int num) {
                return ((num & num-1) == 0) ? "power of 2" : "not a power of 2";
            }
        }

        class NotPrivate {

            void someMethod() {
                System.out.println("Called someMethod in StaticInnerClassDemo.Inner.NotPrivate class!");
            }
        }

    }//end of Inner

}
