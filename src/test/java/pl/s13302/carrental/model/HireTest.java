package pl.s13302.carrental.model;

import org.junit.Test;
import pl.s13302.carrental.BaseTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HireTest extends BaseTest {

    @Test
    public void testDurationWhenDifferenceIs60() {
        // Given:
        Hire hire = new Hire();
        hire.setStart(LocalDateTime.of(2020, 1, 1, 9, 0, 0, 0));
        hire.setFinish(LocalDateTime.of(2020, 1, 1, 10, 0, 0, 0));

        // When:
        Long duration = hire.getDuration();

        // Then:
        assertNotNull("Counted duration should not be null", duration);
        assertEquals("Counted duration should be equal to 60", 60L, duration.longValue());
    }

    @Test
    public void testDurationWhenDifferenceIs1500() {
        Hire hire = new Hire();
        hire.setStart(LocalDateTime.of(2020, 1, 1, 9, 0, 0, 0));
        hire.setFinish(LocalDateTime.of(2020, 1, 2, 10, 0, 0, 0));

        // When:
        Long duration = hire.getDuration();

        // Then:
        assertNotNull("Counted duration should not be null", duration);
        assertEquals("Counted duration should be equal to 1500", 1500L, duration.longValue());
    }

    @Test
    public void testCountPriceFor60Minutes() {
        // Given:
        Car car = new DefaultCar();
        Hire hire = new Hire();
        hire.setCar(car);
        hire.setStart(LocalDateTime.of(2020, 1, 1, 9, 0, 0, 0));
        hire.setFinish(LocalDateTime.of(2020, 1, 1, 10, 0, 0, 0));

        // When:
        BigDecimal price = hire.countPrice();

        // Then:
        assertNotNull("Counted price should not be null", price);
        assertEquals("Counted price should be equal to 3.6", new BigDecimal("3.60"), price);
    }

    @Test
    public void testCountPriceFor66Minutes() {
        // Given:
        Car car = new DefaultCar();
        Hire hire = new Hire();
        hire.setCar(car);
        hire.setStart(LocalDateTime.of(2020, 1, 1, 9, 0, 0, 0));
        hire.setFinish(LocalDateTime.of(2020, 1, 1, 10, 6, 0, 0));

        // When:
        BigDecimal price = hire.countPrice();

        // Then:
        assertNotNull("Counted price should not be null", price);
        assertEquals("Counted price should be equal to 4.2", new BigDecimal("4.20"), price);
    }

    @Test
    public void testCountPriceFor1500Minutes() {
        // Given:
        Car car = new DefaultCar();
        Hire hire = new Hire();
        hire.setCar(car);
        hire.setStart(LocalDateTime.of(2020, 1, 1, 9, 0, 0, 0));
        hire.setFinish(LocalDateTime.of(2020, 1, 2, 10, 0, 0, 0));

        // When:
        BigDecimal price = hire.countPrice();

        // Then:
        assertNotNull("Counted price should not be null", price);
        assertEquals("Counted price should be equal to 90", new BigDecimal("90.00"), price);
    }

}
