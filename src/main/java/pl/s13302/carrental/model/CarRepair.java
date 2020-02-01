package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_repair_generator")
    @SequenceGenerator(name = "car_repair_generator", initialValue = 1000)
    private Long id;

    @OneToMany(mappedBy = "carRepair", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Repair> repairs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(repairs);
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarRepair{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
