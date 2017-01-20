package com.abugauche.bootcamp.Builder;
import com.abugauche.bootcamp.Domain.*;

/**
 * Created by Usuario on 20/1/2017.
 */
public class ConditionBuilder {
    private Day newDate;
    private int newTemp;
    private State newState;
    private Weather newWeather;
    private  Atmosphere newAtmosphere;
    private Wind newWind;

    public ConditionBuilder() {
    }

    public ConditionBuilder setNewDate(Day newDate) {
        this.newDate = newDate;
        return this;
    }


    public ConditionBuilder setNewTemp(int newTemp) {
        this.newTemp = newTemp;
        return this;
    }


    public ConditionBuilder setNewState(State newState) {
        this.newState = newState;
        return this;
    }


    public ConditionBuilder setNewWeather(Weather newWeather) {
        this.newWeather = newWeather;
        return this;
    }


    public ConditionBuilder setNewAtmosphere(Atmosphere newAtmosphere) {
        this.newAtmosphere = newAtmosphere;
        return this;
    }


    public ConditionBuilder setNewWind(Wind newWind) {
        this.newWind = newWind;
        return this;
    }

    public Condition createCondition() {
        return new Condition(newDate, newTemp, newState, newWeather, newAtmosphere,newWind);
    }
}
