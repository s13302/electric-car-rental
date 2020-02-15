package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.Main;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.helper.PeopleTableModel;
import pl.s13302.carrental.model.Person;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class PeopleListGUI extends BaseGUI {

    private static final String TITLE = "";

    private JButton button;

    public PeopleListGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
        setSize(600, 400);
    }

    @Override
    public JPanel showWindow() {
        Collection<Person> people = getApplicationService().getAllPeople();
        PeopleTableModel tableModel = new PeopleTableModel(people, getApplicationService().getClock());

        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(event -> {
            if (! event.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    if (button != null) {
                        panel.remove(button);
                    }
                    button = new JButton("Wypożyczenia");
                    button.addActionListener(e -> {
                        Main.personId = (long) table.getValueAt(selectedRow, 0);
                        try {
                            showNextWindow(this, HireListGUI.class, getApplicationService());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    panel.add(button, BorderLayout.PAGE_END);
                    panel.validate();
                }
            }
        });

        return panel;
    }
}
