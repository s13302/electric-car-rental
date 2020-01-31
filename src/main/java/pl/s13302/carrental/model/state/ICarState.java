package pl.s13302.carrental.model.state;

import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.enums.CarState;

import java.time.Clock;

/**
 * State design pattern for Car
 * @see Car
 */
public interface ICarState {

    CarState releaseCar(Car car, Clock clock);

}
