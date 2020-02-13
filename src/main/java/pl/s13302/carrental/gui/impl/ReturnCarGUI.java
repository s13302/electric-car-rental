package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.Main;
import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;

public class ReturnCarGUI extends BaseGUI {

    private static final String TITLE = "Zwróć samochód";

    public ReturnCarGUI(IApplicationService applicationService) {
        super(TITLE, applicationService);
    }

    @Override
    public JPanel showWindow() {
        try {
            NotFinishedHireDescription hireDescription = getApplicationService().countPrice(Main.hireId);
            JPanel panel = new JPanel(new BorderLayout());

            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(0, 0, 240, 135);
            panel.add(imageLabel, BorderLayout.LINE_START);
            ImageIcon imageIcon = new ImageIcon(Config.getResourceFile("assets/" + hireDescription.getCarImage()));
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

            JPanel rightColumn = new JPanel(new BorderLayout());

            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            rightColumn.add(rightPanel, BorderLayout.CENTER);

            JLabel rentTime = new JLabel("Czas wypożyczenia: " + hireDescription.getRentTime() + " min");
            JLabel price = new JLabel("Wyliczona cena: " + hireDescription.getPrice() + " PLN");
            jLabelWithBold(price);
            rightPanel.add(rentTime);
            rightPanel.add(price);

            JButton returnButton = new JButton("Zwróć");
            returnButton.addActionListener((event) -> {
                try {
                    showNextWindow(this, ReturnAcceptGUI.class, getApplicationService());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            rightColumn.add(returnButton, BorderLayout.PAGE_END);

            panel.add(rightColumn, BorderLayout.CENTER);
            return panel;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
