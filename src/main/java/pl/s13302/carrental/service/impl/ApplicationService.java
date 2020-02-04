package pl.s13302.carrental.service.impl;

import pl.s13302.carrental.configuration.DatabaseOperation;
import pl.s13302.carrental.model.Car;
import pl.s13302.carrental.model.CreditCard;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.service.IApplicationService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class ApplicationService implements IApplicationService {

    @Override
    public BigDecimal countPrice(Long hireId, Clock clock) {
        BigDecimal price = null;

        return (BigDecimal) ((DatabaseOperation) (session) -> {
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();
            hire.setFinish(LocalDateTime.now(clock));
            BigDecimal result = hire.countPrice();
            hire.setFinish(null);
            return result;
        }).run();
    }

    @Override
    public void releaseCar(Long hireId, Clock clock) {
        ((DatabaseOperation) (session) -> {
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();

            hire.getCar().releaseCar(clock);
            BigDecimal price = hire.countPrice();

            CreditCard creditCard = hire.getPerson().getCreditCards().toArray(new CreditCard[0])[0];
            creditCard.releaseLock();
            creditCard.charge(price);
            return null;
        }).run();
    }

}
