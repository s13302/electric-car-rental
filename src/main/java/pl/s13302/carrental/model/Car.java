package pl.s13302.carrental.model;

import pl.s13302.carrental.model.enums.CarState;
import pl.s13302.carrental.model.factory.CarStateFactory;
import pl.s13302.carrental.model.state.ICarState;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Clock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator", initialValue = 1000)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarState state;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hire> hires = new HashSet<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Insurance> insurances = new HashSet<>();

    @Transient
    private ICarState carState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
        this.carState = CarStateFactory.createCarState(state);
    }

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public Hire getStartedHire() {
        for (Hire hire : hires) {
            if (hire.getFinish() == null) {
                return hire;
            }
        }
        return null;
    }

    public void setHires(Set<Hire> hires) {
        this.hires = hires;
    }

    public Set<Insurance> getInsurances() {
        return Collections.unmodifiableSet(insurances);
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    @Transient
    public abstract BigDecimal getHourPrice();

    public void releaseCar(Clock clock) {
        setState(this.carState.releaseCar(this, clock));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", hourPrice=").append(getHourPrice());
        sb.append('}');
        return sb.toString();
    }
}
