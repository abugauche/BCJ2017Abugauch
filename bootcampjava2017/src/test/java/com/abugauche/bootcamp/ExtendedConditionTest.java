package com.abugauche.bootcamp;

import com.abugauche.bootcamp.Domain.ExtendedCondition;
import com.abugauche.bootcamp.Builder.*;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Usuario on 19/1/2017.
 */
public class ExtendedConditionTest {
    public ExtendedConditionTest() {
    }

    @Test
    public void testExtendedDate(){
        int a = 1;
        ExtendedConditionBuilder instance = new ExtendedConditionBuilder();
        instance.setNewDay(a);
        ExtendedCondition e = instance.createExtendedCondition();
        assertEquals(a,e.getDay());
    }

    public void testHigh(){
        int a = 1;
        ExtendedConditionBuilder instance = new ExtendedConditionBuilder();
        instance.setNewHigh(a);
        ExtendedCondition e = instance.createExtendedCondition();
        assertEquals(a,e.getHigh());
    }

    public void testLow(){
        int a = 1;
        ExtendedConditionBuilder instance = new ExtendedConditionBuilder();
        instance.setNewLow(a);
        ExtendedCondition e = instance.createExtendedCondition();
        assertEquals(a,e.getLow());
    }
}