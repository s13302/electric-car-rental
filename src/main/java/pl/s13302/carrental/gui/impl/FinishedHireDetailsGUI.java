package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.Main;
import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;

public class FinishedHireDetailsGUI extends BaseGUI {

    private static final String TITLE = "";

    public FinishedHireDetailsGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
    }

    @Override
    public JPanel showWindow() {
        Hire hire = getApplicationService().getHireById(Main.hireId);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 240, 135);
        panel.add(imageLabel, BorderLayout.LINE_START);
        ImageIcon imageIcon = new ImageIcon(Config.getResourceFile("assets/bmwi3.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(new JLabel("Czas wypożyczenia: " + hire.getDuration() + " min"));
        rightPanel.add(new JLabel("Wyliczona opłata: " + hire.countPrice() + " PLN"));
        Car car = hire.getCar();
        rightPanel.add(new JLabel("Samochód: " + car.getBrand() + " " + car.getModel()));
        panel.add(rightPanel, BorderLayout.CENTER);

        JButton backBtn = new JButton("Powrót");
        backBtn.addActionListener(e -> {
            try {
                showNextWindow(this, HireListGUI.class, getApplicationService());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        panel.add(backBtn, BorderLayout.PAGE_END);

        return panel;
    }
}
