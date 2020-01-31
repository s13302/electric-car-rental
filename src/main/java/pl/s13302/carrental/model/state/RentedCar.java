package pl.s13302.carrental.model.state;

import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.model.enums.CarState;

import java.time.Clock;
import java.time.LocalDateTime;

public class RentedCar implements ICarState {

    @Override
    public CarState releaseCar(Car car, Clock clock) {
        Hire hire = car.getStartedHire();
        if (hire != null) {
            hire.setFinish(LocalDateTime.now(clock));
        }
        return CarState.FREE;
    }

}
