package pl.s13302.carrental.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Repair {

    private Fault fault;
    private CarRepair carRepair;
    private Set<ReplacedElement> replacedElements = new HashSet<>();

    public Repair(Fault fault, CarRepair carRepair) {
        setFault(fault);
        setCarRepair(carRepair);
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        if (this.fault != fault) {
            if (this.fault != null) {
                this.fault.removeRepair(this);
            }
            this.fault = fault;
            fault.addRepair(this);
        }
    }

    public CarRepair getCarRepair() {
        return carRepair;
    }

    public void setCarRepair(CarRepair carRepair) {
        if (this.carRepair != carRepair) {
            if (this.carRepair != null) {
                this.carRepair.removeRepair(this);
            }
            this.carRepair = carRepair;
            carRepair.addRepair(this);
        }
    }

    public Set<ReplacedElement> getReplacedElements() {
        return Collections.unmodifiableSet(replacedElements);
    }

    public void addReplacedElement(ReplacedElement replacedElement) {
        if (! replacedElements.contains(replacedElement)) {
            replacedElements.add(replacedElement);
            replacedElement.setRepair(this);
        }
    }

    public void removeReplacedElement(ReplacedElement replacedElement) {
        if (replacedElements.contains(replacedElement)) {
            replacedElements.remove(replacedElement);
            replacedElement.setRepair(null);
        }
    }

}
