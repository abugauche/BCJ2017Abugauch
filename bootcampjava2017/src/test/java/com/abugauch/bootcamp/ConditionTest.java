package com.abugauch.bootcamp;

import com.abugauch.bootcamp.Domain.*;
import com.abugauch.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class ConditionTest {
    public ConditionTest() {
    }

    @Test
    public void testDay(){
        DayBuilder day = new DayBuilder();
        day.setNewDay(19);
        day.setNewMonth(1);
        day.setNewYear(2017);
        Day d = day.createDay();
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewDate(d);
        Condition c = instance.createCondition();
        assertEquals(d,c.getDate());
    }

    @Test
    public void testTemp(){
        int a = 1;
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewTemp(a);
        Condition c = instance.createCondition();
        assertEquals(a,c.getTemp());
    }

    @Test
    public void testState(){
        CountryBuilder country = new CountryBuilder();
        country.setNewName("Argentina");
        country.setNewAlpa2_code("AR");
        country.setNewAlpa3_code("ARG");
        Country c = country.createCountry();
        StateBuilder state = new StateBuilder();
        state.setNewAbbr("Cba");
        state.setNewArea(100);
        state.setNewCapital("Córdoba");
        state.setNewCountry(c);
        state.setNewName("Córdoba");
        State s= state.createState();
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewState(s);
        Condition co = instance.createCondition();
        assertEquals(s,co.getState());
    }

    @Test
    public void testWeather(){
        WeatherBuilder weather = new WeatherBuilder();
        weather.setNewDescr("Sunny");
        weather.setNewIdWeather(1);
        Weather we = weather.createWeather();
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewWeather(we);
        Condition c = instance.createCondition();
        assertEquals(we,c.getWeather());
    }

    @Test
    public void testWind(){
        WindBuilder wind = new WindBuilder();
        wind.setNewChill(1);
        wind.setNewDirection(1);
        wind.setNewIdWind(1);
        wind.setNewSpeed(1);
        Wind w = wind.createWind();
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewWind(w);
        Condition c = instance.createCondition();
        assertEquals(w,c.getWind());
    }

    @Test
    public void testAtmosphere(){
        AtmosphereBuilder atmosphere = new AtmosphereBuilder();
        atmosphere.setNewHumidity(1);
        atmosphere.setNewIdAtmosphere(1);
        atmosphere.setNewPresseure(1.5f);
        atmosphere.setNewRising(1);
        atmosphere.setNewVisibility(1.5f);
        Atmosphere a = atmosphere.createAtmosphere();
        ConditionBuilder instance = new ConditionBuilder();
        instance.setNewAtmosphere(a);
        Condition c = instance.createCondition();
        assertEquals(a,c.getAtmosphere());
    }

}