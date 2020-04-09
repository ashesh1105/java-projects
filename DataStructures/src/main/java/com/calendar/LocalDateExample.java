package com.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
An example where you can store data in a list with a class that takes LocalDate as a field and some form of data.
You can make the class implement Comparator using the LocalDate field and hence sort the data to retrieve the data
for latest date anytime.
 */

public class LocalDateExample {

    public static void main(String[] args) {

        // Let's use a collection with LocalDate and sort it
        List<TodaysData> dailyData = new ArrayList<>();
        dailyData.add(new TodaysData(LocalDate.now(), 1.0));
        dailyData.add(new TodaysData(LocalDate.of(2020, 4, 7), 2.0));
        dailyData.add(new TodaysData(LocalDate.of(2020, 2, 15), 3.0));
        dailyData.add(new TodaysData(LocalDate.of(2020, 8, 19), 10.0));
        dailyData.add(new TodaysData(LocalDate.of(2020, 11, 15), 1.0));

        // Sort the list now since our TodaysData class implements Comparable
        Collections.sort(dailyData);

        System.out.println("Printing sorted data:");
        dailyData.forEach(todaysData -> {
            System.out.println(todaysData.getDate() + ": " + todaysData.getData());
        });

        System.out.println("Printing latest data which should be the latest one");
        System.out.println(dailyData.get(0).getDate() + ": " + dailyData.get(0).getData());


    }

}
