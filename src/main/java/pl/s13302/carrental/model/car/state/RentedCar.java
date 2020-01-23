package pl.s13302.carrental.model.car.state;

import pl.s13302.carrental.model.car.Car;
import pl.s13302.carrental.model.car.CarState;

public class RentedCar implements CarState {

    public CarState releaseCar(Car car) {
        return new FreeCar();
    }

    public String getStateName() {
        return "Rented";
    }
}
