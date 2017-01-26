package com.abugauch.bootcamp;


/**
 * Created by Abugauch Emmanuel  on 19/1/2017.
 */
import com.abugauch.bootcamp.Domain.Country;
import com.abugauch.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
public class CountryTest {

    public CountryTest(){

    }

    @Test
    public void testName(){
        String a = "Argentina";
        CountryBuilder instance =  new CountryBuilder();
        instance.setNewName(a);
        Country c = instance.createCountry();
        assertEquals(a,c.getName());
       }

    @Test
    public void testAlpha2Code(){
        String a = "AR";
        CountryBuilder instance =  new CountryBuilder();
        instance.setNewAlpa2_code(a);
        Country c = instance.createCountry();;
        assertEquals(a,c.getAlpa2_code());
    }

    @Test
    public void testAlpha3Code(){
        String a = "ARG";
        CountryBuilder instance =  new CountryBuilder();
        instance.setNewAlpa3_code(a);
        Country c = instance.createCountry();
        assertEquals(a,c.getAlpa3_code());
    }
}