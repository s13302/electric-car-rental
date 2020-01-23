package pl.s13302.carrental.model.hire;

import org.junit.Test;
import pl.s13302.carrental.error.ErrorRegister;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.Assert.*;

public class HireTest {

    @Test
    public void testDurationWhenFinishIsNull() {
        // Given:
        LocalDateTime start = LocalDateTime.of(2020, 9, 25, 13, 20);
        Hire hire = new Hire(start);

        // When:
        long duration = hire.getDuration();
        Collection<String> errors = ErrorRegister.getRegisteredErrors();

        // Then:
        assertEquals("getDuration should return -1 when finish is not set", -1L, duration);
        assertTrue("getDuration method should raise an error", errors.contains("Cannot count duration when hire is not finished."));

    }

    @Test
    public void testDurationWhenFinishIsNotNull() {
        // Given:
        LocalDateTime start = LocalDateTime.of(2020, 9, 25, 13, 20);
        LocalDateTime finish = start.plusMinutes(10);
        Hire hire = new Hire(start, finish);

        // When:
        long duration = hire.getDuration();

        // Then
        assertEquals("getDuration should count minutes correctly", 10L, duration);
    }

}