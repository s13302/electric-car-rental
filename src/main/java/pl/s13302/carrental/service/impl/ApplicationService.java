package pl.s13302.carrental.service.impl;

import pl.s13302.carrental.configuration.DatabaseOperation;
import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.model.CreditCard;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.service.IApplicationService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class ApplicationService implements IApplicationService {

    private final Clock clock;

    public ApplicationService(Clock clock) {
        this.clock = clock;
    }

    @Override
    public Clock getClock() {
        return clock;
    }

    @Override
    public NotFinishedHireDescription countPrice(Long hireId) {
        return (NotFinishedHireDescription) ((DatabaseOperation) (session) -> {
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();
            hire.setFinish(LocalDateTime.now(getClock()));
            BigDecimal countedPrice = hire.countPrice();
            long distance = 300L;
            long time = hire.getDuration();
            hire.setFinish(null);
            return new NotFinishedHireDescription(countedPrice, distance, time);
        }).run();
    }

    @Override
    public void releaseCar(Long hireId) {
        ((DatabaseOperation) (session) -> {
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();

            hire.getCar().releaseCar(getClock());
            BigDecimal price = hire.countPrice();

            CreditCard creditCard = hire.getPerson().getCreditCards().toArray(new CreditCard[0])[0];
            creditCard.releaseLock();
            creditCard.charge(price);
            return null;
        }).run();
    }

}
