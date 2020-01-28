package pl.s13302.carrental.model;

import java.math.BigDecimal;

public class ReplacedElement {

    private final String name;
    private final BigDecimal price;
    private Repair repair;

    public ReplacedElement(String name, BigDecimal price, Repair repair) {
        this.name = name;
        this.price = price;
        setRepair(repair);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        if (this.repair != repair) {
            if (this.repair != null) {
                this.repair.removeReplacedElement(this);
            }
            this.repair = repair;
            repair.addReplacedElement(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacedElement{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", repair=").append(repair);
        sb.append('}');
        return sb.toString();
    }
}
