package pl.s13302.carrental;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.configuration.IConstants;
import pl.s13302.carrental.gui.BaseGUI;
import pl.s13302.carrental.gui.impl.HireListGUI;
import pl.s13302.carrental.gui.impl.PeopleListGUI;
import pl.s13302.carrental.service.IApplicationService;
import pl.s13302.carrental.service.impl.ApplicationService;

import javax.swing.*;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Scanner;

public class Main {

    public static Clock DEFAULT_CLOCK;
    public static IApplicationService applicationService;

    public static long personId;
    public static long hireId;

    public static void main(String[] args) throws Exception {
        initializeApp();

        SwingUtilities.invokeLater(() -> {
            try {
                BaseGUI.showNextWindow(null, PeopleListGUI.class, applicationService);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void initializeApp() throws Exception {
        Config.loadConfiguration();
        DEFAULT_CLOCK = Clock.system(ZoneId.of(Config.getStringPropertyValue(IConstants.PROPERTY_ZONE_ID)));
        applicationService = new ApplicationService(DEFAULT_CLOCK);
    }

}
