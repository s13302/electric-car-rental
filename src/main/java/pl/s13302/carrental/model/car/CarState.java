package pl.s13302.carrental.model.car;

public interface CarState {

    CarState releaseCar(Car car);

    String getStateName();

}
