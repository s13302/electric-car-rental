package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private boolean personInFault;

    @OneToMany(mappedBy = "fault", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hire> hires;

    @OneToMany(mappedBy = "fault", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Repair> repairs;

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
        return hires;
    }

    public void setHires(Set<Hire> hires) {
        this.hires = hires;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("id=").append(id);
        sb.append(", personInFault=").append(personInFault);
        sb.append(", hires=").append(hires);
        sb.append('}');
        return sb.toString();
    }
}
