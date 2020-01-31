package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private boolean personInFault;

    @OneToMany(mappedBy = "fault", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hire> hires = new HashSet<>();

    @OneToMany(mappedBy = "fault", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Repair> repairs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPersonInFault() {
        return personInFault;
    }

    public void setPersonInFault(boolean personInFault) {
        this.personInFault = personInFault;
    }

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public void setHires(Set<Hire> hires) {
        this.hires = hires;
    }

    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(repairs);
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("id=").append(id);
        sb.append(", personInFault=").append(personInFault);
        sb.append(", hires=").append(hires);
        sb.append(", repairs=").append(repairs);
        sb.append('}');
        return sb.toString();
    }
}
