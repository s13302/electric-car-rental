package pl.s13302.carrental.model.hire.strategy;

import pl.s13302.carrental.model.hire.Hire;
import pl.s13302.carrental.model.hire.PriceCalculatorStrategy;

import java.math.BigDecimal;

public class DefaultCarPriceCalculator implements PriceCalculatorStrategy {

    @Override
    public BigDecimal countPrice(Hire hire) {
        return null;
    }

}
