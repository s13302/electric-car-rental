package pl.s13302.carrental.model.creditcard;

import java.math.BigDecimal;

public interface CreditCard {

    void releaseLock();

    void charge(BigDecimal price);
}
