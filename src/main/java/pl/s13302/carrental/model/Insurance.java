package pl.s13302.carrental.model;

import java.time.LocalDate;

public class Insurance {

    private final LocalDate from;
    private LocalDate to;

    public Insurance(LocalDate from) {
        this.from = from;
    }

    public Insurance(LocalDate from, LocalDate to) {
        this(from);
        setTo(to);
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Insurance{");
        sb.append("from=").append(from);
        sb.append(", to=").append(to);
        sb.append('}');
        return sb.toString();
    }
}
