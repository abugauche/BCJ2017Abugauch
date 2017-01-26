package com.abugauch.bootcamp.Builder;

/**
 * Created by Usuario on 20/1/2017.
 */
import com.abugauch.bootcamp.Domain.Day;

public class DayBuilder {
    private int newDay;
    private int newMonth;
    private int newYear;

    public DayBuilder() {
    }

    public DayBuilder setNewDay(int newDay) {
        this.newDay = newDay;
        return this;
    }


    public DayBuilder setNewMonth(int newMonth) {
        this.newMonth = newMonth;
        return this;
    }


    public DayBuilder setNewYear(int newYear) {
        this.newYear = newYear;
        return this;
    }

    public Day createDay() {
        return new Day(newDay, newMonth, newYear);
    }

}
