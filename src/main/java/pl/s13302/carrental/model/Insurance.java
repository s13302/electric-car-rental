package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date insuranceFrom;

    @Temporal(TemporalType.DATE)
    private Date insuranceTo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInsuranceFrom() {
        return insuranceFrom;
    }

    public void setInsuranceFrom(Date insuranceFrom) {
        this.insuranceFrom = insuranceFrom;
    }

    public Date getInsuranceTo() {
        return insuranceTo;
    }

    public void setInsuranceTo(Date insuranceTo) {
        this.insuranceTo = insuranceTo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Insurance{");
        sb.append("id=").append(id);
        sb.append(", insuranceFrom=").append(insuranceFrom);
        sb.append(", insuranceTo=").append(insuranceTo);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
