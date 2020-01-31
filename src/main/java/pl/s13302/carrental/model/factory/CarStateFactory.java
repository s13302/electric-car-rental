package pl.s13302.carrental.model.factory;

import pl.s13302.carrental.model.enums.CarState;
import pl.s13302.carrental.model.state.FreeCar;
import pl.s13302.carrental.model.state.ICarState;
import pl.s13302.carrental.model.state.RentedCar;

public class CarStateFactory {

    /**
     * Creates ICarState depending on current car state
     * @see ICarState
     * @param state state of the car
     * @return ICarState implementation
     */
    public static ICarState createCarState(CarState state) {
        switch (state) {
            case FREE:
                return new FreeCar();
            case RENTED:
                return new RentedCar();
        }
        return null;
    }

}
