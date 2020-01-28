package pl.s13302.carrental.model.car;

import com.sun.istack.internal.NotNull;
import pl.s13302.carrental.error.ErrorRegister;
import pl.s13302.carrental.model.Insurance;
import pl.s13302.carrental.model.hire.Hire;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Car {

    private final String brand;
    private final String model;
    private CarState state;
    private Set<Hire> hires = new HashSet<>();
    private Set<Insurance> insurances = new HashSet<>();

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

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public void addHire(Hire hire) {
        if (! hires.contains(hire)) {
            hires.add(hire);
            hire.setCar(this);
        }
    }

    public void removeHire(Hire hire) {
        if (hires.contains(hire)) {
            hires.remove(hire);
            hire.setCar(null);
        }
    }

    public Set<Insurance> getInsurances() {
        return Collections.unmodifiableSet(insurances);
    }

    public void addInsurance(Insurance insurance) {
        if (! insurances.contains(insurance)) {
            insurances.add(insurance);
            insurance.setCar(this);
        }
    }

    public void removeInsurance(Insurance insurance) {
        if (insurances.contains(insurance)) {
            if (insurances.size() <= 1) {
                ErrorRegister.addError("Cannot remove last insurance");
                return;
            }
            insurances.remove(insurance);
            insurance.setCar(null);
        }
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
