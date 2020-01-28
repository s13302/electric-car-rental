package pl.s13302.carrental.model.hire;

import pl.s13302.carrental.error.ErrorRegister;
import pl.s13302.carrental.model.Fault;
import pl.s13302.carrental.model.Person;
import pl.s13302.carrental.model.car.Car;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Hire {

    private final LocalDateTime start;
    private final PriceCalculatorStrategy priceCalculatorStrategy;
    private Person person;
    private Car car;
    private Fault fault;
    private LocalDateTime finish;

    public Hire(LocalDateTime start, Person person, Car car, PriceCalculatorStrategy priceCalculatorStrategy) {
        this.start = start;
        this.priceCalculatorStrategy = priceCalculatorStrategy;
        setPerson(person);
        setCar(car);
    }

    public Hire(LocalDateTime start, Person person, Car car, PriceCalculatorStrategy priceCalculatorStrategy, LocalDateTime finish) {
        this(start, person, car, priceCalculatorStrategy);
        setFinish(finish);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if (this.person != person) {
            if (this.person != null) {
                this.person.removeHire(this);
            }
            this.person = person;
            person.addHire(this);
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.car != car) {
            if (this.car != null) {
                this.car.removeHire(this);
            }
            this.car = car;
            car.addHire(this);
        }
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        if (this.fault != fault) {
            if (this.fault != null) {
                this.fault.removeHire(this);
            }
            this.fault = fault;
            fault.addHire(this);
        }
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
     * Counts price of the hire. Using PriceCalculatorStrategy
     * @see pl.s13302.carrental.model.hire.PriceCalculatorStrategy
     * @return the price
     */
    public BigDecimal countPrice() {
        if (finish == null) {
            ErrorRegister.addError("Cannot count duration when hire is not finished.");
            return BigDecimal.ONE.negate();
        }
        return priceCalculatorStrategy.countPrice(this);
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
