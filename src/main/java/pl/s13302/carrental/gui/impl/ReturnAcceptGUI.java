package pl.s13302.carrental.gui.impl;

import pl.s13302.carrental.gui.BaseGUI;
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
        JPanel panel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new JLabel("Czas wypożyczenia: x:xx"));
        leftPanel.add(new JLabel("Przejechany dystans: xxx km"));

        JLabel priceLabel = new JLabel("Wyliczona cena: xxx PLN");
        Font priceFont = priceLabel.getFont();
        priceLabel.setFont(priceFont.deriveFont(priceFont.getStyle() | Font.BOLD));
        leftPanel.add(priceLabel);

        panel.add(leftPanel, BorderLayout.CENTER);

        JPanel secondPanel = new JPanel(new BorderLayout());
        secondPanel.add(new JButton("Akceptuj"), BorderLayout.PAGE_END);
        panel.add(secondPanel, BorderLayout.LINE_END);

        return panel;
    }
}
