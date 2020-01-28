package pl.s13302.carrental.model.creditcard;

import pl.s13302.carrental.model.Person;

import java.math.BigDecimal;

public class CreditCardLocalStub implements CreditCard {

    private Person person;

    public CreditCardLocalStub(Person person) {
        setPerson(person);
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPerson(Person person) {
        if (this.person != person) {
            if (this.person != null) {
                this.person.removeCreditCard(this);
            }
            this.person = person;
            person.addCreditCard(this);
        }
    }

    @Override
    public void releaseLock() {

    }

    @Override
    public void charge(BigDecimal price) {

    }
}
