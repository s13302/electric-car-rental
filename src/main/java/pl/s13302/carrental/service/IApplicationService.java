package pl.s13302.carrental.service;

import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.model.Hire;

import java.time.Clock;
import java.util.Collection;

public interface IApplicationService {

    Collection<Hire> getAllPersonHires(long personId);

    Clock getClock();

    NotFinishedHireDescription countPrice(long hireId);

    void releaseCar(Long hireId);

    void finalizeService();

}
