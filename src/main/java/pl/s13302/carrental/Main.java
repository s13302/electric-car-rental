package pl.s13302.carrental;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.configuration.DatabaseOperation;
import pl.s13302.carrental.configuration.IConstants;
import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.DefaultCar;
import pl.s13302.carrental.model.enums.CarState;

import java.time.Clock;
import java.time.ZoneId;
import java.util.List;

public class Main {

    public static Clock DEFAULT_CLOCK;

    public static void main(String[] args) throws Exception {
        initializeApp();

        ((DatabaseOperation) (session) -> {
            Car car = new DefaultCar();
            car.setBrand("BMW");
            car.setModel("i3");
            car.setState(CarState.RENTED);
            session.saveOrUpdate(car);

            List<Car> cars = session.createQuery("from pl.s13302.carrental.model.Car").list();

            cars.forEach(current -> {
                current.releaseCar(DEFAULT_CLOCK);
                session.saveOrUpdate(current);

                System.out.println(current);
            });
        }).run();
    }

    private static void initializeApp() throws Exception {
        Config.loadConfiguration();
        DEFAULT_CLOCK = Clock.system(ZoneId.of(Config.getStringPropertyValue(IConstants.PROPERTY_ZONE_ID)));
    }

}
