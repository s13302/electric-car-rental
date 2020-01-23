package pl.s13302.carrental.model.car;

import java.math.BigDecimal;

public class DefaultCar extends Car {

    public static final BigDecimal PRICE = BigDecimal.valueOf(.6);

    public DefaultCar(String brand, String model, CarState state) {
        super(brand, model, state);
    }
}
