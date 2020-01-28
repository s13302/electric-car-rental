package pl.s13302.carrental.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.car.Car;
import pl.s13302.carrental.model.car.DefaultCar;
import pl.s13302.carrental.model.car.state.FreeCar;

import java.time.Clock;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class InsuranceTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testCarAssociation() {
        // Given:
        Insurance insurance = new Insurance(LocalDate.now(clock), null);
        Car car = new DefaultCar("BMW", "i3", new FreeCar());

        // When:
        insurance.setCar(car);

        // Then:
        assertSame("Insurance should have association to Car", car, insurance.getCar());
        assertTrue("Car should have association to Insurance", car.getInsurances().contains(insurance));
    }

}
