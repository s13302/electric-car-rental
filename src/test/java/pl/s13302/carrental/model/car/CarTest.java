package pl.s13302.carrental.model.car;

import org.junit.Test;
import org.junit.Before;

import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.Insurance;
import pl.s13302.carrental.model.car.state.FreeCar;
import pl.s13302.carrental.model.hire.Hire;
import pl.s13302.carrental.model.hire.strategy.DefaultCarPriceCalculator;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CarTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testHireAssociation() {
        // Given:
        Car car = new DefaultCar("BMW", "i3", new FreeCar());
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        car.addHire(hire);

        // Then:
        assertTrue("Car should have association to Hire", car.getHires().contains(hire));
        assertSame("Hire should have association to Car", car, hire.getCar());
    }

    @Test
    public void testInsuranceAssociation() {
        // Given:
        Insurance insurance = new Insurance(LocalDate.now(clock), null);
        Car car = new DefaultCar("BMW", "i3", new FreeCar());

        // When:
        car.addInsurance(insurance);

        // Then:
        assertTrue("Car should have association to Insurance", car.getInsurances().contains(insurance));
        assertSame("Insurance should have association to Car", car, insurance.getCar());
    }

}
