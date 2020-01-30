package pl.s13302.carrental.model;

import javax.persistence.*;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        sb.append(", charger=").append(charger);
        sb.append('}');
        return sb.toString();
    }
}
