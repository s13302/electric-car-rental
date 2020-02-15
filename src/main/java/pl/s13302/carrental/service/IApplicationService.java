package pl.s13302.carrental.service;

import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.model.Person;

import java.time.Clock;
import java.util.Collection;

public interface IApplicationService {

    Collection<Person> getAllPeople();

    Collection<Hire> getAllPersonHires(long personId);

    Clock getClock();

    NotFinishedHireDescription countPrice(long hireId);

    Hire getHireById(long hireId);

    void releaseCar(Long hireId);

    void finalizeService();

}
