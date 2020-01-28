package pl.s13302.carrental;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.configuration.IConstants;

import java.time.Clock;
import java.time.ZoneId;

public class Main {

    private static Clock DEFAULT_CLOCK;

    public static void main(String[] args) throws Exception {
        initializeApp();
    }

    private static void initializeApp() throws Exception {
        Config.loadConfiguration();
        DEFAULT_CLOCK = Clock.system(ZoneId.of(Config.getStringPropertyValue(IConstants.PROPERTY_ZONE_ID)));
    }

}
