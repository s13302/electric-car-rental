package pl.s13302.carrental.model.car.state;

import pl.s13302.carrental.error.ErrorRegister;
import pl.s13302.carrental.model.car.Car;
import pl.s13302.carrental.model.car.CarState;

public class FreeCar implements CarState {

    public CarState releaseCar(Car car) {
        ErrorRegister.addError("Cannot release a free car");
        return this;
    }

    public String getStateName() {
        return "Free";
    }
}
