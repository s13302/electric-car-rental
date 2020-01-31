package pl.s13302.carrental.model;

import org.junit.Before;
import org.junit.Test;
import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.enums.CarState;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CarTest extends BaseTest {

    @Test
    public void testReleaseCarForRentedCar() {
        // Given:
        Hire hire = new Hire();
        hire.setStart(LocalDateTime.now(testClock));
        Set<Hire> hires = new HashSet<>();
        hires.add(hire);
        Car car = new DefaultCar();
        car.setState(CarState.RENTED);
        car.setHires(hires);

        // When:
        car.releaseCar(testClock);

        // Then:
        assertEquals("Car state should be FREE after release", CarState.FREE, car.getState());
        assertNotNull("Hire should have finish time", hire.getFinish());
        assertEquals("Finish time should be equal to now", LocalDateTime.now(testClock), hire.getFinish());
    }

    @Test(expected = IllegalStateException.class)
    public void testReleaseCarWhenFreeCar() {
        // Given:
        Hire hire = new Hire();
        hire.setStart(LocalDateTime.now(testClock));
        Car car = new DefaultCar();
        car.setState(CarState.FREE);

        // When:
        car.releaseCar(testClock);

        // Then:
        // Should throw an IllegalStateException
    }

}
