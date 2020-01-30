package pl.s13302.carrental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date finish;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
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
