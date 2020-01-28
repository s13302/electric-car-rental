package pl.s13302.carrental.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ReplacedElementTest {

    @Test
    public void testRepairAssociation() {
        // Given:
        Repair repair = new Repair(null, null);
        ReplacedElement replacedElement = new ReplacedElement("Name", BigDecimal.ONE, null);

        // When:
        replacedElement.setRepair(repair);

        // Then:
        assertSame("ReplacedElement should have association to Repair", repair, replacedElement.getRepair());
        assertTrue("Repair should have association to ReplacedElement", repair.getReplacedElements().contains(replacedElement));
    }

}