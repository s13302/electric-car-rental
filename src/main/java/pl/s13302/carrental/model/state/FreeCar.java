package pl.s13302.carrental.model.state;

import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.enums.CarState;

import java.time.Clock;

public class FreeCar implements ICarState {

    @Override
    public CarState releaseCar(Car car, Clock clock) {
        throw new IllegalStateException("Cannot release free car");
    }

}
