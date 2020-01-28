package pl.s13302.carrental.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarRepairTest {

    @Test
    public void testRepairAssociation() {
        // Given:
        Repair repair = new Repair(null, null);
        CarRepair carRepair = new CarRepair();

        // When:
        carRepair.addRepair(repair);

        // Then:
        assertTrue("CarRepair should have association to Repair", carRepair.getRepairs().contains(repair));
        assertSame("Repair should have association to CarRepair", carRepair, repair.getCarRepair());
    }

}