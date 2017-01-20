package com.abugauche.bootcamp;

import com.abugauche.bootcamp.Domain.Weather;
import junit.framework.TestCase;
import com.abugauche.bootcamp.Builder.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class WeatherTest {
    public WeatherTest() {
    }

    @Test
    public void testIdWeather(){
        int a = 1;
        WeatherBuilder instance =  new WeatherBuilder();
        instance.setNewIdWeather(a);
        Weather w = instance.createWeather();
        assertEquals(a,w.getIdWeather());
    }

    @Test
    public void testDescr(){
        String a = "Sunny";
        WeatherBuilder instance =  new WeatherBuilder();
        instance.setNewDescr(a);
        Weather w = instance.createWeather();
        assertEquals(a,w.getDescr());
    }
}