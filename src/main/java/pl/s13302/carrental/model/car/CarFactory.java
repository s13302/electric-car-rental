package pl.s13302.carrental.model.car;

import pl.s13302.carrental.model.car.state.FreeCar;

public class CarFactory {

    public static DefaultCar createDefaultCar(String brand, String model) {
        CarState state = new FreeCar();
        return new DefaultCar(brand, model, state);
    }

}
