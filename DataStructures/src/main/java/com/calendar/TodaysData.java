package com.calendar;

import lombok.Getter;

import java.time.LocalDate;

public class TodaysData {

    @Getter
    private LocalDate date;
    @Getter
    private Double data;

    public TodaysData(LocalDate ldt, Double data) {
        this.date = ldt;
        this.data = data;
    }

//    @Override
//    public int compareTo(TodaysData o) {
//        // Allows sorting via latest date - check class TryAnything for more details
//        return -this.date.compareTo(o.getDate());
//    }
}
