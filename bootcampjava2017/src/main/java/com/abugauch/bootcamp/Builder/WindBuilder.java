package com.abugauch.bootcamp.Builder;
import com.abugauch.bootcamp.Domain.Wind;

/**
 * Created by Usuario on 20/1/2017.
 */
public class WindBuilder {
    private int newIdWind;
    private int newChill;
    private int newDirection;
    private int newSpeed;

    public WindBuilder() {
    }

    public WindBuilder setNewIdWind(int newIdWind) {
        this.newIdWind = newIdWind;
        return this;
    }

    public WindBuilder setNewChill(int newChill) {
        this.newChill = newChill;
        return this;
    }

    public WindBuilder setNewDirection(int newDirection) {
        this.newDirection = newDirection;
        return this;
    }

    public WindBuilder setNewSpeed(int newSpeed) {
        this.newSpeed = newSpeed;
        return this;
    }

    public Wind createWind(){
        return new Wind(newIdWind,newChill,newDirection,newSpeed);
    }
}
