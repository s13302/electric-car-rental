package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "carRepair", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Repair> repairs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarRepair{");
        sb.append("id=").append(id);
        sb.append(", repairs=").append(repairs);
        sb.append('}');
        return sb.toString();
    }
}
