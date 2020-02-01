package pl.s13302.carrental.model;

import javax.persistence.*;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stand_generator")
    @SequenceGenerator(name = "stand_generator", initialValue = 1000)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Charger charger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stand{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
