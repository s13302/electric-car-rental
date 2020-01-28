package pl.s13302.carrental.model;

import pl.s13302.carrental.model.hire.Hire;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Fault {

    private final boolean personInFault;
    private Set<Hire> hires = new HashSet<>();
    private Set<Repair> repairs = new HashSet<>();

    public Fault(boolean personInFault) {
        this.personInFault = personInFault;
    }

    public boolean isPersonInFault() {
        return personInFault;
    }

    public Set<Hire> getHires() {
        return Collections.unmodifiableSet(hires);
    }

    public void addHire(Hire hire) {
        if (! hires.contains(hire)) {
            hires.add(hire);
            hire.setFault(this);
        }
    }

    public void removeHire(Hire hire) {
        if (hires.contains(hire)) {
            hires.remove(hire);
            hire.setFault(null);
        }
    }

    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(repairs);
    }

    public void addRepair(Repair repair) {
        if (! repairs.contains(repair)) {
            repairs.add(repair);
            repair.setFault(this);
        }
    }

    public void removeRepair(Repair repair) {
        if (repairs.contains(repair)) {
            repairs.remove(repair);
            repair.setFault(null);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("personInFault=").append(personInFault);
        sb.append('}');
        return sb.toString();
    }
}
