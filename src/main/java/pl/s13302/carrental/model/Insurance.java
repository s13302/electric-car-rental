package pl.s13302.carrental.model;

import pl.s13302.carrental.model.car.Car;

import java.time.LocalDate;

public class Insurance {

    private final LocalDate from;
    private LocalDate to;
    private Car car;

    public Insurance(LocalDate from, Car car) {
        this.from = from;
        setCar(car);
    }

    public Insurance(LocalDate from, Car car, LocalDate to) {
        this(from, car);
        setTo(to);
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.car != car) {
            if (this.car != null) {
                this.car.removeInsurance(this);
            }
            this.car = car;
            car.addInsurance(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Insurance{");
        sb.append("from=").append(from);
        sb.append(", to=").append(to);
        sb.append('}');
        return sb.toString();
    }
}
