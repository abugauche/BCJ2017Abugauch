/**
 * Created by Abugauch Emmanuel  on 10/1/2017.
 */
package com.abugauch.bootcamp.Domain;
public class Atmosphere {
    private int idAtmosphere;
    private int humidity;
    private Double presseure;
    private int rising;
    private Double visibility;

    public Atmosphere(){
    }

    public Atmosphere(int idAtmosphere, int humidity, Double presseure, int rising, Double visibility) {
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

    public Double getPresseure() {
        return presseure;
    }

    public void setPresseure(Double presseure) {
        this.presseure = presseure;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
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
