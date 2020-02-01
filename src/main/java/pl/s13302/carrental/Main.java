package pl.s13302.carrental;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.configuration.DatabaseOperation;
import pl.s13302.carrental.configuration.IConstants;
import pl.s13302.carrental.model.Car;

import java.time.Clock;
import java.time.ZoneId;
import java.util.List;

public class Main {

    public static Clock DEFAULT_CLOCK;

    public static void main(String[] args) throws Exception {
        initializeApp();

        ((DatabaseOperation) (session) -> {
            List<Car> cars = session.createQuery("from pl.s13302.carrental.model.Car").list();
            cars.forEach(System.out::println);
        }).run();
    }

    private static void initializeApp() throws Exception {
        Config.loadConfiguration();
        DEFAULT_CLOCK = Clock.system(ZoneId.of(Config.getStringPropertyValue(IConstants.PROPERTY_ZONE_ID)));
    }

}
