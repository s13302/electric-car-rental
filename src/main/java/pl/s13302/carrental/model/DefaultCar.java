package pl.s13302.carrental.model;

import pl.s13302.carrental.configuration.Config;
import pl.s13302.carrental.configuration.IConstants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("DEFAULT")
public class DefaultCar extends Car {

    private static final BigDecimal PRICE = new BigDecimal(
            (Config.getStringPropertyValue(IConstants.PROPERTY_CAR_DEFAULT_PRICE) != null) ?
                    Config.getStringPropertyValue(IConstants.PROPERTY_CAR_DEFAULT_PRICE) :
                    "0.6"
    );

    @Override
    public BigDecimal getHourPrice() {
        return PRICE;
    }

}
