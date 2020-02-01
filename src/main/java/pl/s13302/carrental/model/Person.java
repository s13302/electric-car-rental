package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", initialValue = 1000)
    private Long id;

    @Column(nullable = false)
    private String drivingLicenseNumber;

    @Temporal(TemporalType.DATE)
    private Date drivingLicenseValidTo;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CreditCard> creditCards = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hire> hires = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Date getDrivingLicenseValidTo() {
        return drivingLicenseValidTo;
    }

    public void setDrivingLicenseValidTo(Date drivingLicenseValidTo) {
        this.drivingLicenseValidTo = drivingLicenseValidTo;
    }

    public Set<CreditCard> getCreditCards() {
        return Collections.unmodifiableSet(creditCards);
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public void setHires(Set<Hire> hires) {
        this.hires = hires;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", drivingLicenseNumber='").append(drivingLicenseNumber).append('\'');
        sb.append(", drivingLicenseValidTo=").append(drivingLicenseValidTo);
        sb.append('}');
        return sb.toString();
    }
}
