package pl.s13302.carrental.model;

import pl.s13302.carrental.model.creditcard.CreditCard;
import pl.s13302.carrental.model.hire.Hire;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Person {

    private final String drivingLicenseNumber;
    private LocalDate drivingLicenseValidTo;
    private Set<CreditCard> creditCards = new HashSet<>();
    private Set<Hire> hires = new HashSet<>();

    public Person(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Person(String drivingLicenseNumber, LocalDate drivingLicenseValidTo) {
        this(drivingLicenseNumber);
        setDrivingLicenseValidTo(drivingLicenseValidTo);
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public LocalDate getDrivingLicenseValidTo() {
        return drivingLicenseValidTo;
    }

    public void setDrivingLicenseValidTo(LocalDate drivingLicenseValidTo) {
        this.drivingLicenseValidTo = drivingLicenseValidTo;
    }

    public Set<CreditCard> getCreditCards() {
        return Collections.unmodifiableSet(creditCards);
    }

    public void addCreditCard(CreditCard creditCard) {
        if (! creditCards.contains(creditCard)) {
            creditCards.add(creditCard);
            creditCard.setPerson(this);
        }
    }

    public void removeCreditCard(CreditCard creditCard) {
        if (creditCards.contains(creditCard)) {
            creditCards.remove(creditCard);
            creditCard.setPerson(null);
        }
    }

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public void addHire(Hire hire) {
        if (! hires.contains(hire)) {
            hires.add(hire);
            hire.setPerson(this);
        }
    }

    public void removeHire(Hire hire) {
        if (hires.contains(hire)) {
            hires.remove(hire);
            hire.setPerson(null);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("drivingLicenseNumber='").append(drivingLicenseNumber).append('\'');
        sb.append(", drivingLicenseValidTo=").append(drivingLicenseValidTo);
        sb.append('}');
        return sb.toString();
    }
}
