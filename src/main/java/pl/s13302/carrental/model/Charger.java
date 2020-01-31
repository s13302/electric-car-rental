package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Charger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "charger", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Stand> stands = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Stand> getStands() {
        return Collections.unmodifiableSet(stands);
    }

    public void setStands(Set<Stand> stands) {
        this.stands = stands;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Charger{");
        sb.append("id=").append(id);
        sb.append(", stands=").append(stands);
        sb.append('}');
        return sb.toString();
    }
}
