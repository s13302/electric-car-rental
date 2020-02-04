package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.gui.BaseGUI;
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
            JPanel panel = new JPanel(new BorderLayout());

            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(0, 0, 240, 135);
            panel.add(imageLabel, BorderLayout.LINE_START);
            ImageIcon imageIcon = new ImageIcon(Config.getResourceFile("assets/bmwi3.jpg"));
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

            JPanel rightColumn = new JPanel(new BorderLayout());

            JPanel hireInformation = new JPanel();
            hireInformation.setLayout(new BoxLayout(hireInformation, BoxLayout.Y_AXIS));
            hireInformation.add(new JLabel("Długość czasu wypożyczenia[min]: "));
            hireInformation.add(new JLabel("Aktualny koszt[PLN]: "));
            rightColumn.add(hireInformation, BorderLayout.CENTER);
            rightColumn.add(new JButton("Zwróć"), BorderLayout.PAGE_END);

            panel.add(rightColumn, BorderLayout.CENTER);
            return panel;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
