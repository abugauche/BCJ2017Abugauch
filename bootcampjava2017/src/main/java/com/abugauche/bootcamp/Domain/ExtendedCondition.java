/**
 * Created by Abugauch Emmanuel  on 11/1/2017.
 */
package com.abugauche.bootcamp.Domain;
public class ExtendedCondition {
    private int extendedDate;
    private int high;
    private int low;
    private Condition condition;
    private Weather weather;

    public ExtendedCondition() {
    }

    public ExtendedCondition(int extendedDate, int high, int low, Condition condition, Weather weather) {
        this.extendedDate = extendedDate;
        this.high = high;
        this.low = low;
        this.condition = condition;
        this.weather = weather;
    }

    public int getDay() {
        return extendedDate;
    }

    public void setDay(int extendedDate) {
        this.extendedDate = extendedDate;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "ExtendedCondition{" +
                "extendedDate=" + (extendedDate) +
                ", high=" + high +
                ", low=" + low +
                ", Actually day=" + condition.getDate() +
                ", weather=" + weather.getDescr() +
                '}';
    }
}
