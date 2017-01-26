/**
 * Created by Abugauch Emmanuel  on 10/1/2017.
 */
package com.abugauch.bootcamp.Domain;
public class Atmosphere {
    private int idAtmosphere;
    private int humidity;
    private float presseure;
    private int rising;
    private float visibility;

    public Atmosphere(){
    }

    public Atmosphere(int idAtmosphere, int humidity, float presseure, int rising, float visibility) {
        this.idAtmosphere = idAtmosphere;
        this.humidity = humidity;
        this.presseure = presseure;
        this.rising = rising;
        this.visibility = visibility;
    }

    public int getIdAtmosphere() {
        return idAtmosphere;
    }

    public void setIdAtmosphere(int idAtmosphere) {
        this.idAtmosphere = idAtmosphere;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getPresseure() {
        return presseure;
    }

    public void setPresseure(float presseure) {
        this.presseure = presseure;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Atmosphere{" +
                "idAtmosphere=" + idAtmosphere +
                ", humidity=" + humidity +
                ", presseure=" + presseure +
                ", rising=" + rising +
                ", visibility=" + visibility +
                '}';
    }
}
