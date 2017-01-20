package com.abugauche.bootcamp.Builder;
import com.abugauche.bootcamp.Domain.Weather;

/**
 * Created by Usuario on 20/1/2017.
 */
public class WeatherBuilder {
    private int newIdWeather;
    private String newDescr;

    public WeatherBuilder() {
    }

    public WeatherBuilder setNewIdWeather(int newIdWeather) {
        this.newIdWeather = newIdWeather;
        return this;
    }

    public WeatherBuilder setNewDescr(String newDescr) {
        this.newDescr = newDescr;
        return this;
    }
    public Weather createWeather(){
        return new Weather(newIdWeather,newDescr);
    }
}
