package pl.s13302.carrental.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ReplacedElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Repair repair;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacedElement{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", repair=").append(repair);
        sb.append('}');
        return sb.toString();
    }
}
