package com.algorithms.hackerrank.strings;

/**
 Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

 Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

 Example:

 s = "12:01:00PM"
 Return: "12:01:00"

 s = "12:01:01AM"
 Return "00:01:00"

 Solution:
 We have two situations here:
 1) When hour is 12:
    This has two cases too:
    A) When it is 12:mm:ssPM
        Here, we need to just remove the PM and we're good on 24 hour clock, i.e., get to: 12:mm:ss
    B) When it is 12:mm:ssAM
        Here, we need to not only remove AM but also replace hour by 00, i.e., get to: 00:mm:ss
 2) When hour is not 12:
    A) If it is AM, just remove AM from time and we get it like 07:mm:ss
    B) If it is PM, we need to grab the hour, parse as int, add 12 to that and then replace that from time, also
       remove PM from it, so it will be like 15:mm:ss (when input was: 03:mm:ssPM)
 */

public class TwelveTo24HourClockTimeConversion {

    public static void main(String[] args) {

        // Let's get 4 test cases to cover all the possible scenarios
        String twelveHourTime1 = "12:34:56AM";
        String twelveHourTime2 = "08:59:59AM";
        String twelveHourTime3 = "12:05:49PM";
        String twelveHourTime4 = "05:21:53PM";

        System.out.printf("12 Hour Clock Time: %s, converted to %s as 24 Hour Clock Time.", twelveHourTime1,
                TwelveTo24HourClock(twelveHourTime1));

        System.out.println("");

        System.out.printf("12 Hour Clock Time: %s, converted to %s as 24 Hour Clock Time.", twelveHourTime2,
                TwelveTo24HourClock(twelveHourTime2));

        System.out.println("");

        System.out.printf("12 Hour Clock Time: %s, converted to %s as 24 Hour Clock Time.", twelveHourTime3,
                TwelveTo24HourClock(twelveHourTime3));

        System.out.println("");

        System.out.printf("12 Hour Clock Time: %s, converted to %s as 24 Hour Clock Time.", twelveHourTime4,
                TwelveTo24HourClock(twelveHourTime4));

    }

    static String TwelveTo24HourClock(String s) {

        // Null and empty input checks
        if (s == null || s.length() < 2) return s;

        String result = "";
        int len = s.length();
        boolean isPM = s.substring(len-2, len).equals("PM") ? true : false;

        // Check if special rules will apply, i.e., input is for 12:mm:ss (PM or AM)
        if (s.substring(0,2).equals("12")) {
            if (isPM) {
                result = s.substring(0, len-2);
            } else {
                result = "00" + s.substring(2, len-2);
            }
        } else if (isPM) {  // Else, apply the general conversion rules for AM and PM (+12 on hour for PM)
            result = Integer.parseInt(s.substring(0,2)) + 12 + s.substring(2, len-2);
        } else {
            result = s.substring(0, len-2);
        }

        return result;

    }

}
