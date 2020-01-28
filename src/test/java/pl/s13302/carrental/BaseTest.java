package pl.s13302.carrental;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class BaseTest {

    public Clock getTestClock() {
        return Clock.fixed(Instant.parse("2020-01-25T12:16:32.00Z"), ZoneId.of("Europe/Warsaw"));
    }

}
