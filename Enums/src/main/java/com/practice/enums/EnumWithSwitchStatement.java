package com.practice.enums;

/**
 * Every enum constant represents an object of type enum.
 * enum type can be passed as an argument to switch statement.
 */

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY;
}

public class EnumWithSwitchStatement {

    private Day day;

    public EnumWithSwitchStatement(Day day) {
        this.day = day;
    }

    // Prints a line about Day using switch
    public void dayIsLike() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    // Driver method
    public static void main(String[] args) {
        String str = "FRIDAY";
        EnumWithSwitchStatement enumWithSwitchStatement = new EnumWithSwitchStatement(Day.valueOf(str));
        enumWithSwitchStatement.dayIsLike();
    }
}
