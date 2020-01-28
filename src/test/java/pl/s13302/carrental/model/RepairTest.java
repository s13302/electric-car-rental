package pl.s13302.carrental.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.carrental.BaseTest;

import java.math.BigDecimal;
import java.time.Clock;

import static org.junit.Assert.*;

public class RepairTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testFaultAssociation() {
        // Given:
        Fault fault = new Fault(true);
        Repair repair = new Repair(null, null);

        // When:
        repair.setFault(fault);

        // Then:
        assertSame("Repair should have association to Fault", fault, repair.getFault());
        assertTrue("Fault should have association to Repair", fault.getRepairs().contains(repair));
    }

    @Test
    public void testCarRepairAssociation() {
        // Given:
        Repair repair = new Repair(null, null);
        CarRepair carRepair = new CarRepair();

        // When:
        repair.setCarRepair(carRepair);

        // Then:
        assertSame("Repair should have association to CarRepair", carRepair, repair.getCarRepair());
        assertTrue("CarRepair should have association to Repair", carRepair.getRepairs().contains(repair));
    }

    @Test
    public void testReplacedElementAssociation() {
        // Given:
        Repair repair = new Repair(null, null);
        ReplacedElement replacedElement = new ReplacedElement("Name", BigDecimal.ONE, null);

        // When:
        repair.addReplacedElement(replacedElement);

        // Then:
        assertTrue("Repair should have association to ReplacedElement", repair.getReplacedElements().contains(replacedElement));
        assertSame("ReplacedElement should have association to Repair", repair, replacedElement.getRepair());
    }

}