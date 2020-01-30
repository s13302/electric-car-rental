package pl.s13302.carrental.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DEFAULT")
public class DefaultCar extends Car {
}
