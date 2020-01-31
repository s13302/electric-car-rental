package pl.s13302.carrental;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class BaseTest {

    public int day = 1, month = 1, year = 2020, hour = 2, minute = 30, second = 0, millis = 0;
    public ZoneId zoneId = ZoneId.of("Europe/Warsaw");
    public Clock testClock = Clock.fixed(Instant.parse("2020-01-01T02:30:00.00Z"), zoneId);

}
