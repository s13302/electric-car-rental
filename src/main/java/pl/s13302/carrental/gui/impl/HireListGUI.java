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

    public HireListGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
        setSize(600, 400);
    }

    @Override
    public JPanel showWindow() {
        Collection<Hire> hires = getApplicationService().getAllPersonHires(Main.personId);
        HireTableModel tableModel = new HireTableModel(hires);

        JTable table = new JTable(tableModel);
        JButton detailsBtn = new JButton("Szczegóły");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(detailsBtn, BorderLayout.PAGE_END);

        return panel;
    }

}
