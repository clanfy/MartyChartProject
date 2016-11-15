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

}
