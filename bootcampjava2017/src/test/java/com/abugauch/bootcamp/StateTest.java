package com.abugauch.bootcamp;

import com.abugauch.bootcamp.Domain.State;
import com.abugauch.bootcamp.Domain.Country;
import com.abugauch.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class StateTest {
    public StateTest() {
    }

    @Test
    public void testName(){
        String a = "Cordoba";
        State instance =  new State();
        instance.setName(a);
        assertEquals(a,instance.getName());
    }

    @Test
    public void testAbbr(){
        String a = "Cba";
        State instance =  new State();
        instance.setAbbr(a);
        assertEquals(a,instance.getAbbr());
    }

    @Test
    public void testArea(){
        int a = 100;
        State instance =  new State();
        instance.setArea(a);
        assertEquals(a,instance.getArea());
    }

    @Test
    public void testCapital(){
        String a = "Córdoba";
        State instance =  new State();
        instance.setCapital(a);
        assertEquals(a,instance.getCapital());
    }

    @Test
    public void testCountry(){
        Country a = new Country("Argentina","AR","ARG");
        State instance =  new State();
        instance.setCountry_name(a.getName());
        assertEquals(a.getName(),instance.getCountry_name());
    }
}