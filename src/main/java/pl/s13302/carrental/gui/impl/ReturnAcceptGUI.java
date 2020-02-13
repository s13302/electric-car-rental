package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.Main;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;

public class ReturnAcceptGUI extends BaseGUI {

    private static final String TITLE = "Akceptacja";

    public ReturnAcceptGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
    }

    @Override
    public JPanel showWindow() {
        NotFinishedHireDescription hireDescription = getApplicationService().countPrice(Main.hireId);
        JPanel panel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        panel.add(leftPanel, BorderLayout.CENTER);

        JLabel rentTime = new JLabel("Czas wypożyczenia: " + hireDescription.getRentTime() + " min");
        JLabel distance = new JLabel("Przejechany dystans: " + hireDescription.getDistance() + " km");
        JLabel price = new JLabel("Wyliczona cena: " + hireDescription.getPrice() + " PLN");
        jLabelWithBold(price);
        leftPanel.add(rentTime);
        leftPanel.add(distance);
        leftPanel.add(price);

        JPanel secondPanel = new JPanel(new BorderLayout());

        JButton acceptButton = new JButton("Akceptuj");
        acceptButton.addActionListener((event) -> {
            getApplicationService().releaseCar(Main.hireId);
            Main.hireId = -1;
            JOptionPane.showMessageDialog(null, "Wypożyczenie zakończono pomyślnie");
            try {
                showNextWindow(this, HireListGUI.class, getApplicationService());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        secondPanel.add(acceptButton, BorderLayout.PAGE_END);
        panel.add(secondPanel, BorderLayout.LINE_END);

        return panel;
    }
}
