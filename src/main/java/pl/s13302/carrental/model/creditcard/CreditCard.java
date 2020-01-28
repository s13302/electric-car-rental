package pl.s13302.carrental.model.creditcard;

import pl.s13302.carrental.model.Person;

import java.math.BigDecimal;

public interface CreditCard {

    Person getPerson();

    void setPerson(Person person);

    void releaseLock();

    void charge(BigDecimal price);
}
