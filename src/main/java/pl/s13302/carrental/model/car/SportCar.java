package pl.s13302.carrental.model.car;

import java.math.BigDecimal;

public class SportCar extends Car {

    public static final BigDecimal PRICE = BigDecimal.valueOf(1.2);

    public SportCar(String brand, String model, CarState state) {
        super(brand, model, state);
    }
}
