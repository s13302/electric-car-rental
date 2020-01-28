package pl.s13302.carrental.model;

import org.junit.Test;
import org.junit.Before;

import java.time.Clock;
import java.time.LocalDateTime;

import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.creditcard.CreditCard;
import pl.s13302.carrental.model.creditcard.CreditCardLocalStub;
import pl.s13302.carrental.model.hire.Hire;
import pl.s13302.carrental.model.hire.strategy.DefaultCarPriceCalculator;

import static org.junit.Assert.*;

public class PersonTest extends BaseTest {

    private Clock clock;

    @Before
    public void setup() {
        clock = getTestClock();
    }

    @Test
    public void testHireAssociation() {
        // Given:
        Person person = new Person("");
        Hire hire = new Hire(LocalDateTime.now(clock), null, null, new DefaultCarPriceCalculator());

        // When:
        person.addHire(hire);

        // Then:
        assertTrue("Person should have association to Hire", person.getHires().contains(hire));
        assertSame("Hire should have association to Person", person, hire.getPerson());
    }

    @Test
    public void testCreditCardAssociation() {
        // Given:
        Person person = new Person("");
        CreditCard creditCard = new CreditCardLocalStub(null);

        // When:
        person.addCreditCard(creditCard);

        // Then:
        assertTrue("Person should have association to CreditCard", person.getCreditCards().contains(creditCard));
        assertSame("CreditCard should have association to Person", person, creditCard.getPerson());
    }

}
