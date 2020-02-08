package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;

public class ReturnAcceptGUI extends BaseGUI {

    private static final String TITLE = "Akceptacja";

    private final Long hireId = 3L;

    private JPanel leftPanel = new JPanel();
    private JLabel rentTime = null;
    private JLabel distance = null;
    private JLabel price = null;

    public ReturnAcceptGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
    }

    @Override
    public void tick() {
        NotFinishedHireDescription hireDescription = getApplicationService().countPrice(hireId);

        if (rentTime != null) {
            leftPanel.remove(rentTime);
        }
        if (distance != null) {
            leftPanel.remove(distance);
        }
        if (price != null) {
            leftPanel.remove(price);
        }

        rentTime = new JLabel("Czas wypożyczenia: " + hireDescription.getRentTime() + " min");
        distance = new JLabel("Przejechany dystans: " + hireDescription.getDistance() + " km");
        price = new JLabel("Wyliczona cena: " + hireDescription.getPrice() + " PLN");

        Font priceFont = price.getFont();
        price.setFont(priceFont.deriveFont(priceFont.getStyle() | Font.BOLD));

        leftPanel.add(rentTime);
        leftPanel.add(distance);
        leftPanel.add(price);
    }

    @Override
    public JPanel showWindow() {
        JPanel panel = new JPanel(new BorderLayout());

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        panel.add(leftPanel, BorderLayout.CENTER);

        JPanel secondPanel = new JPanel(new BorderLayout());
        secondPanel.add(new JButton("Akceptuj"), BorderLayout.PAGE_END);
        panel.add(secondPanel, BorderLayout.LINE_END);

        return panel;
    }
}
