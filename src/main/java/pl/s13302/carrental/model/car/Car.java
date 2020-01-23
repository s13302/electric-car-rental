package pl.s13302.carrental.model.car;

import com.sun.istack.internal.NotNull;

public abstract class Car {

    private final String brand;
    private final String model;
    private CarState state;

    public Car(@NotNull String brand, @NotNull String model, @NotNull CarState state) {
        this.brand = brand;
        this.model = model;
        this.state = state;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    private void setState(CarState state) {
        this.state = state;
    }

    public void releaseCar() {
        setState(state.releaseCar(this));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
