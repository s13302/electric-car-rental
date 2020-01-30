package pl.s13302.carrental.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SPORT")
public class SportCar extends Car {

}
