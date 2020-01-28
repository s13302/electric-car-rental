package pl.s13302.carrental.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarRepair {

    private Set<Repair> repairs = new HashSet<>();

    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(repairs);
    }

    public void addRepair(Repair repair) {
        if (! repairs.contains(repair)) {
            repairs.add(repair);
            repair.setCarRepair(this);
        }
    }

    public void removeRepair(Repair repair) {
        if (repairs.contains(repair)) {
            repairs.remove(repair);
            repair.setCarRepair(null);
        }
    }

}
