package pl.s13302.carrental.service;

import pl.s13302.carrental.helper.NotFinishedHireDescription;

import java.time.Clock;

public interface IApplicationService {

    Clock getClock();

    NotFinishedHireDescription countPrice(Long hireId);

    void releaseCar(Long hireId);

}
