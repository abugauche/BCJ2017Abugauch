package com.abugauche.bootcamp.Builder;
import com.abugauche.bootcamp.Domain.*;

/**
 * Created by Usuario on 20/1/2017.
 */
public class StateBuilder {
    private String newName;
    private String newAbbr;//abbreviation
    private int newArea;//size
    private String newCapital;
    private Country newCountry;

    public StateBuilder() {
    }

    public StateBuilder setNewName(String newName) {
        this.newName = newName;
return this;    }

    public StateBuilder setNewAbbr(String newAbbr) {
        this.newAbbr = newAbbr;
        return this;
    }

    public StateBuilder setNewArea(int newArea) {
        this.newArea = newArea;
        return this;
    }

    public StateBuilder setNewCapital(String newCapital) {
        this.newCapital = newCapital;
        return this;
    }

    public StateBuilder setNewCountry(Country newCountry) {
        this.newCountry = newCountry;
        return this;
    }
    public State createState(){
        return new State(newName,newAbbr,newArea,newCapital,newCountry);
    }
}
