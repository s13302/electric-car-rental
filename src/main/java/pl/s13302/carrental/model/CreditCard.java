package pl.s13302.carrental.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(unique = true, nullable = false)
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
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }
}
