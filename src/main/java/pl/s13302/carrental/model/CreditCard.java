package pl.s13302.carrental.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_generator")
    @SequenceGenerator(name = "credit_card_generator", initialValue = 1000)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void releaseLock() {}

    public void charge(BigDecimal price) {}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreditCard{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
