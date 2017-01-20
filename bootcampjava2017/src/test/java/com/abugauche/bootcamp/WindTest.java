package com.abugauche.bootcamp;

import com.abugauche.bootcamp.Domain.Wind;
import com.abugauche.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class WindTest {
    public WindTest() {
    }

    @Test
    public void testIdWind(){
        int a = 1;
        WindBuilder instance =  new WindBuilder();
        instance.setNewIdWind(a);
        Wind w = instance.createWind();
        assertEquals(a,w.getIdWind());
    }

    @Test
    public void testChill(){
        int a = 1;
        WindBuilder instance =  new WindBuilder();
        instance.setNewChill(a);
        Wind w = instance.createWind();
        assertEquals(a,w.getChill());
    }

    @Test
    public void testDirection(){
        int a = 1;
        WindBuilder instance =  new WindBuilder();
        instance.setNewDirection(a);
        Wind w = instance.createWind();
        assertEquals(a,w.getDirection());
    }

    @Test
    public void testSpeed(){
        int a = 1;
        WindBuilder instance =  new WindBuilder();
        instance.setNewSpeed(a);
        Wind w = instance.createWind();
        assertEquals(a,w.getSpeed());
    }
}