package pl.s13302.carrental.model;

import java.math.BigDecimal;

public class ReplacedElement {

    private final String name;
    private final BigDecimal price;

    public ReplacedElement(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplacedElement{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
