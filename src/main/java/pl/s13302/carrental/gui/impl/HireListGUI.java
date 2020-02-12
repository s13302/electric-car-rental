package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.Main;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.helper.HireTableModel;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class HireListGUI extends BaseGUI {

    private static final String TITLE = "Historia wypożyczeń";

    private JButton button;

    public HireListGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
        setSize(600, 400);
    }

    @Override
    public JPanel showWindow() {
        Collection<Hire> hires = getApplicationService().getAllPersonHires(Main.personId);
        HireTableModel tableModel = new HireTableModel(hires);

        JTable table = new JTable(tableModel);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(event -> {
            if (! event.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    if (button != null) {
                        panel.remove(button);
                    }
                    boolean hireFinished = (boolean) table.getValueAt(selectedRow, 5);
                    long hireId = (long) table.getValueAt(selectedRow, 0);
                    if (hireFinished) {
                        button = new JButton("Szczegóły");
                    } else {
                        button = new JButton("Zwróć samochód");
                        button.addActionListener(e -> {
                            Main.hireId = hireId;
                            try {
                                showNextWindow(this, ReturnCarGUI.class, getApplicationService());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                    }
                    panel.add(button, BorderLayout.PAGE_END);
                    panel.validate();
                }
            }
        });

        return panel;
    }

}
