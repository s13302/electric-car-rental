package pl.s13302.carrental.model.hire;

import java.math.BigDecimal;

public interface PriceCalculatorStrategy {

    BigDecimal countPrice(Hire hire);

}
