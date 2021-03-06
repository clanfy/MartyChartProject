package com.example.user.martychart;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 15/11/2016.
 */

public class MedicationTest {

    Medication medication;

    @Before
    public void before(){
        medication = new Medication (1, "Viagra", 2, 111216);
    }

    @Test
    public void testMedicationHasName(){
        assertEquals("Viagra", medication.getName());
    }

    @Test
    public void testMedicationHasId(){
        assertEquals(1, medication.getId());
    }

    @Test
    public void testCanGetIdAsString(){
        assertEquals("1", medication.getIdString());
    }

    @Test
    public void testMedicationHasQuantity(){
        assertEquals(2, medication.getQuantity());
    }

    @Test
    public void testCanGetQuantityAsString(){
        assertEquals("2", medication.getQuantityString());
    }

    @Test
    public void testCanGetDate(){
        assertEquals(111216, medication.getDate());
    }

    @Test
    public void testCanGetDateAsString(){
        assertEquals("111216", medication.getDateString());
    }

}
