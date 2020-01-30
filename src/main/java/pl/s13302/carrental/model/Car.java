package pl.s13302.carrental.model;

import pl.s13302.carrental.model.enums.CarState;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarState state;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hire> hires;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Insurance> insurances;

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
    }

    public Set<Hire> getHires() {
        return hires;
    }

    public void setHires(Set<Hire> hires) {
        this.hires = hires;
    }

    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", state=").append(state);
        sb.append(", hires=").append(hires);
        sb.append(", insurances=").append(insurances);
        sb.append('}');
        return sb.toString();
    }
}
