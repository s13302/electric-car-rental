package pl.s13302.carrental.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime start;

    private LocalDateTime finish;

    @ManyToOne
    @JoinColumn(unique = true, nullable = false)
    private Person person;

    @ManyToOne
    private Fault fault;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Transient
    public Long getDuration() {
        if (finish != null && (finish.isAfter(start) || finish.isEqual(start))) {
            return start.until(finish, ChronoUnit.MINUTES);
        }
        return null;
    }

    public BigDecimal countPrice() {
        Long duration = getDuration();
        if (duration != null) {
            BigDecimal carHourPrice = car.getHourPrice();
            if (duration % 10 > 0) {
                duration += 10L;
            }
            duration /= 10;
            return carHourPrice.multiply(BigDecimal.valueOf(duration)).setScale(2);
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hire{");
        sb.append("id=").append(id);
        sb.append(", start=").append(start);
        sb.append(", finish=").append(finish);
        sb.append(", person=").append(person);
        sb.append(", fault=").append(fault);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
