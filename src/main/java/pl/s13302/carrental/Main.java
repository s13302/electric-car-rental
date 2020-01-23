package pl.s13302.carrental;

import pl.s13302.carrental.error.ErrorRegister;
import pl.s13302.carrental.model.car.Car;
import pl.s13302.carrental.model.car.CarFactory;

public class Main {

    public static void main(String[] args) {
        Car car = CarFactory.createDefaultCar("BMW", "i3");
        car.releaseCar();
        System.err.println(ErrorRegister.getRegisteredErrors());
    }

}
