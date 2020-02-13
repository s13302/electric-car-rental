package pl.s13302.carrental.helper;

import java.math.BigDecimal;

public class NotFinishedHireDescription {

    private final BigDecimal price;
    private final long distance;
    private final long rentTime;
    private final String carImage;

    public NotFinishedHireDescription(BigDecimal price, long distance, long rentTime, String carImage) {
        this.price = price;
        this.distance = distance;
        this.rentTime = rentTime;
        this.carImage = carImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getDistance() {
        return distance;
    }

    public long getRentTime() {
        return rentTime;
    }

    public String getCarImage() {
        return carImage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotFinishedHireDescription{");
        sb.append("price=").append(price);
        sb.append(", distance=").append(distance);
        sb.append(", rentTime=").append(rentTime);
        sb.append(", carImage=").append(carImage);
        sb.append('}');
        return sb.toString();
    }
}
