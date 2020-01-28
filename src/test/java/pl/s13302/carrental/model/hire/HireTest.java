package pl.s13302.carrental.model.hire;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.Fault;
import pl.s13302.carrental.model.Person;
import pl.s13302.carrental.model.car.Car;
import pl.s13302.carrental.model.car.DefaultCar;
import pl.s13302.carrental.model.car.state.FreeCar;
import pl.s13302.carrental.model.hire.strategy.DefaultCarPriceCalculator;

import java.time.Clock;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HireTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testPersonAssociation() {
        // Given:
        Person person = new Person("");
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        hire.setPerson(person);

        // Then:
        assertSame("Hire should have association to Person", person, hire.getPerson());
        assertTrue("Person should have association to Hire", person.getHires().contains(hire));
    }

    @Test
    public void testCarAssociation() {
        // Given:
        Car car = new DefaultCar("BMW", "i3", new FreeCar());
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        hire.setCar(car);

        // Then:
        assertSame("Hire should have association to Car", car, hire.getCar());
        assertTrue("Car should have association to Hire", car.getHires().contains(hire));
    }

    @Test
    public void testFaultAssociation() {
        // Given:
        Fault fault = new Fault(true);
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        hire.setFault(fault);

        // Then:
        assertSame("Hire should have association to Fault", fault, hire.getFault());
        assertTrue("Fault should have association to Hire", fault.getHires().contains(hire));
    }

}
