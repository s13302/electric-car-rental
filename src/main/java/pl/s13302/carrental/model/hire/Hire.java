package pl.s13302.carrental.model.hire;

import pl.s13302.carrental.error.ErrorRegister;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Hire {

    private final LocalDateTime start;
    private LocalDateTime finish;

    public Hire(LocalDateTime start) {
        this.start = start;
    }

    public Hire(LocalDateTime start, LocalDateTime finish) {
        this(start);
        setFinish(finish);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        if (finish.isAfter(start)) {
            this.finish = finish;
        } else {
            ErrorRegister.addError("Finish time needs to be after start time.");
        }
    }

    /**
     * Counts price of the hire
     * @see pl.s13302.carrental.model.hire.PriceCalculatorStrategy
     * @return the price
     */
    public BigDecimal countPrice() {
        if (finish == null) {
            ErrorRegister.addError("Cannot count duration when hire is not finished.");
            return BigDecimal.ONE.negate();
        }
        // TODO: Count the price when association to car is ready
        return BigDecimal.ZERO;
    }

    /**
     * Counts duration of the hire. Result is in minutes
     * @return duration in minutes
     */
    public long getDuration() {
        if (finish == null) {
            ErrorRegister.addError("Cannot count duration when hire is not finished.");
            return -1L;
        }
        return Duration.between(start, finish).toMinutes();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hire{");
        sb.append("start=").append(start);
        sb.append(", finish=").append(finish);
        sb.append('}');
        return sb.toString();
    }
}
