package com.abugauche.bootcamp;

import com.abugauche.bootcamp.Domain.Atmosphere;
import com.abugauche.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Abugauch Emmanuel on 18/1/2017.
 */
public class AtmosphereTest  {
    public AtmosphereTest() {
    }

    @Test
    public void testIdAtmosphere(){
        int idAtmosphere = 1;
        AtmosphereBuilder instance =  new AtmosphereBuilder();
        instance.setNewIdAtmosphere(idAtmosphere);
        Atmosphere a = instance.createAtmosphere();
        assertEquals(idAtmosphere,a.getIdAtmosphere());
    }

    @Test
    public void testHumidity(){
        int humidity = 1;
        AtmosphereBuilder instance =  new AtmosphereBuilder();
        instance.setNewHumidity(humidity);
        Atmosphere a = instance.createAtmosphere();

        assertEquals(humidity,a.getHumidity());
    }

    @Test
    public void testPresseure(){
        float presseure = 1.5f;
        AtmosphereBuilder instance =  new AtmosphereBuilder();
        instance.setNewPresseure(presseure);
        Atmosphere a = instance.createAtmosphere();
        assertEquals(presseure,a.getPresseure(),0.0);
    }

    @Test
    public void testRising(){
        int rising = 1;
        AtmosphereBuilder instance =  new AtmosphereBuilder();
        instance.setNewRising(rising);
        Atmosphere a = instance.createAtmosphere();

        assertEquals(rising,a.getRising());
    }

    @Test
    public void testVisibility(){
        float visbility = 1.5f;
        AtmosphereBuilder instance =  new AtmosphereBuilder();
        instance.setNewVisibility(visbility);
        Atmosphere a = instance.createAtmosphere();
        assertEquals(visbility,a.getVisibility(),0.0);
    }
}