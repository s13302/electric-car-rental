package pl.s13302.carrental.service;

import java.math.BigDecimal;
import java.time.Clock;

public interface IApplicationService {

    BigDecimal countPrice(Long hireId, Clock clock);

    void releaseCar(Long hireId, Clock clock);

}
