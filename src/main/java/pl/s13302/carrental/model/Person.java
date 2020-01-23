package pl.s13302.carrental.model;

import java.time.LocalDate;

public class Person {

    private final String drivingLicenseNumber;
    private LocalDate drivingLicenseValidTo;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("drivingLicenseNumber='").append(drivingLicenseNumber).append('\'');
        sb.append(", drivingLicenseValidTo=").append(drivingLicenseValidTo);
        sb.append('}');
        return sb.toString();
    }
}
