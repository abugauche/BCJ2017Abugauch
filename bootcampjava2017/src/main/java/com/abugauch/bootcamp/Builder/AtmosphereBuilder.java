package com.abugauch.bootcamp.Builder;

import com.abugauch.bootcamp.Domain.Atmosphere;

/**
 * Created by Usuario on 20/1/2017.
 */
public class AtmosphereBuilder {
    private int newIdAtmosphere;
    private int newHumidity;
    private float newPresseure;
    private int newRising;
    private float newVisibility;

    public AtmosphereBuilder(){
    }

    public AtmosphereBuilder setNewIdAtmosphere(int newIdAtmosphere) {
        this.newIdAtmosphere = newIdAtmosphere;
        return this;
    }

    public AtmosphereBuilder setNewHumidity(int newHumidity) {
        this.newHumidity = newHumidity;
        return this;
    }

    public AtmosphereBuilder setNewPresseure(float newPresseure) {
        this.newPresseure = newPresseure;
        return this;
    }

    public AtmosphereBuilder setNewRising(int newRising) {
        this.newRising = newRising;
        return this;
    }

    public AtmosphereBuilder setNewVisibility(float newVisibility) {
        this.newVisibility = newVisibility;
        return this;
    }
    public Atmosphere createAtmosphere() {
        return new Atmosphere(newIdAtmosphere, newHumidity, newPresseure, newRising, newVisibility);
    }
}

