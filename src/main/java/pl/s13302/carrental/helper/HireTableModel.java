package pl.s13302.carrental.helper;

import pl.s13302.carrental.model.Hire;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

public class HireTableModel implements TableModel {

    private final String[] COLUMNS = new String[] {
            "Id",
            "Samochód",
            "Data rozpoczęcia",
            "Data zakończenia",
            "Cena [PLN]",
            "Zakończone"
    };

    private final Class[] COLUMN_CLASS = new Class[] {
            Long.class,
            String.class,
            LocalDateTime.class,
            LocalDateTime.class,
            BigDecimal.class,
            Boolean.class
    };

    private final Hire[] hires;

    public HireTableModel(Collection<Hire> hires) {
        this.hires = hires.toArray(new Hire[0]);
    }

    @Override
    public int getRowCount() {
        return hires.length;
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
        Hire hire = hires[rowIndex];
        switch (columnIndex) {
            case 0: return hire.getId();
            case 1: return hire.getCar().getBrand() + " " + hire.getCar().getModel();
            case 2: return hire.getStart();
            case 3: return hire.getFinish();
            case 4: return (hire.isFinished()) ? hire.countPrice() : null;
            case 5: return hire.isFinished();
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
