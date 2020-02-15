package pl.s13302.carrental.helper;

import pl.s13302.carrental.model.Person;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Collection;

public class PeopleTableModel implements TableModel {

    private final String[] COLUMNS = new String[]{
            "Id",
            "Numer Prawo Jazdy",
            "Data ważności PJ",
            "Czy PJ ważne"
    };

    private final Class[] COLUMN_CLASS = new Class[]{
            Long.class,
            String.class,
            LocalDate.class,
            Boolean.class
    };

    private final Person[] people;
    private final Clock clock;

    public PeopleTableModel(Collection<Person> people, Clock clock) {
        this.people = people.toArray(new Person[0]);
        this.clock = clock;
    }

    @Override
    public int getRowCount() {
        return people.length;
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASS[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = people[rowIndex];
        switch (columnIndex) {
            case 0: return person.getId();
            case 1: return person.getDrivingLicenseNumber();
            case 2: return person.getDrivingLicenseValidTo();
            case 3: return person.getDrivingLicenseValidTo().isAfter(LocalDate.now(clock));
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
