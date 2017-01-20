package com.abugauche.bootcamp;

import com.abugauche.bootcamp.Domain.Day;
import com.abugauche.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class DayTest {
    public DayTest() {

    }

    @Test
    public void testDay(){
        int a = 1;
        DayBuilder instance =  new DayBuilder();
        instance.setNewDay(a);
        Day c = instance.createDay();
        assertEquals(a,c.getDay());
    }

    @Test
    public void testMonth(){
        int a = 1;
        DayBuilder instance =  new DayBuilder();
        instance.setNewMonth(a);
        Day c = instance.createDay();
        assertEquals(a,c.getMonth());
    }

    @Test
    public void testYear(){
        int a = 1;
        DayBuilder instance =  new DayBuilder();
        instance.setNewYear(a);
        Day c = instance.createDay();
        assertEquals(a,c.getYear());
    }
}