package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Fault fault;

    @OneToMany(mappedBy = "repair", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReplacedElement> replacedElements = new HashSet<>();

    @ManyToOne
    private CarRepair carRepair;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    public CarRepair getCarRepair() {
        return carRepair;
    }

    public void setCarRepair(CarRepair carRepair) {
        this.carRepair = carRepair;
    }

    public Set<ReplacedElement> getReplacedElements() {
        return Collections.unmodifiableSet(replacedElements);
    }

    public void setReplacedElements(Set<ReplacedElement> replacedElements) {
        this.replacedElements = replacedElements;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repair{");
        sb.append("id=").append(id);
        sb.append(", fault=").append(fault);
        sb.append(", replacedElements=").append(replacedElements);
        sb.append(", carRepair=").append(carRepair);
        sb.append('}');
        return sb.toString();
    }
}
