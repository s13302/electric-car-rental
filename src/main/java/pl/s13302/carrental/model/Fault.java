package pl.s13302.carrental.model;

public class Fault {

    private final boolean personInFault;

    public Fault(boolean personInFault) {
        this.personInFault = personInFault;
    }

    public boolean isPersonInFault() {
        return personInFault;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("personInFault=").append(personInFault);
        sb.append('}');
        return sb.toString();
    }
}
