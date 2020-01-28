package pl.s13302.carrental.model.creditcard;

import org.junit.Test;
import pl.s13302.carrental.BaseTest;
import pl.s13302.carrental.model.Person;

import static org.junit.Assert.*;

public class CreditCardLocalStubTest extends BaseTest {

    @Test
    public void testPersonAssociation() {
        // Given:
        Person person = new Person("");
        CreditCardLocalStub creditCard = new CreditCardLocalStub(null);

        // When:
        creditCard.setPerson(person);

        // Then:
        assertSame("CreditCard should have association to Person", person, creditCard.getPerson());
        assertTrue("Person should have association to CreditCard", person.getCreditCards().contains(creditCard));
    }

}