package com.abugauch.bootcamp.Builder;
import com.abugauch.bootcamp.Domain.*;

/**
 * Created by Usuario on 20/1/2017.
 */
public class ExtendedConditionBuilder {
    private int newExtendedDay;
    private int newHigh;
    private int newLow;
    private Condition newCondition;
    private Weather newWeather;

    public ExtendedConditionBuilder() {
    }

    public ExtendedConditionBuilder setNewDay(int newExtendedDay) {
        this.newExtendedDay = newExtendedDay;
        return this;
    }

    public ExtendedConditionBuilder setNewHigh(int newHigh) {
        this.newHigh = newHigh;
        return this;
    }

    public ExtendedConditionBuilder setNewLow(int newLow) {
        this.newLow = newLow;
        return this;
    }

    public ExtendedConditionBuilder setNewCondition(Condition newCondition) {
        this.newCondition = newCondition;
        return this;
    }

    public ExtendedConditionBuilder setNewWeather(Weather newWeather) {
        this.newWeather = newWeather;
        return this;
    }

    public ExtendedCondition createExtendedCondition() {
        return new ExtendedCondition(newExtendedDay, newHigh, newLow,newCondition,newWeather);
    }
}
