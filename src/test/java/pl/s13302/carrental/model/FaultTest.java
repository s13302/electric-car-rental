package pl.s13302.carrental.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.hire.Hire;
import pl.s13302.carrental.model.hire.strategy.DefaultCarPriceCalculator;

import java.time.Clock;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class FaultTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testHireAssociation() {
        // Given:
        Fault fault = new Fault(true);
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        fault.addHire(hire);

        // Then:
        assertTrue("Fault should have association to Hire", fault.getHires().contains(hire));
        assertSame("Hire should have association to Fault", fault, hire.getFault());
    }

    @Test
    public void testRepairAssociation() {
        // Given:
        Fault fault = new Fault(true);
        Repair repair = new Repair(null, null);

        // When:
        fault.addRepair(repair);

        // Then:
        assertTrue("Fault should have association to Repair", fault.getRepairs().contains(repair));
        assertSame("Repair should have association to Fault", fault, repair.getFault());
    }

}
