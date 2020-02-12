package pl.s13302.carrental.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.s13302.carrental.helper.NotFinishedHireDescription;
import pl.s13302.carrental.model.CreditCard;
import pl.s13302.carrental.model.Hire;
import pl.s13302.carrental.model.Person;
import pl.s13302.carrental.service.IApplicationService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class ApplicationService implements IApplicationService {

    private final Clock clock;

    private final Session session;

    public ApplicationService(Clock clock) throws Exception {
        this.clock = clock;
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public Clock getClock() {
        return clock;
    }

    public Collection<Hire> getAllPersonHires(long personId) {
        try {
            session.beginTransaction();
            Person person = (Person) session.createQuery("from pl.s13302.carrental.model.Person where id=:personId")
                    .setParameter("personId", personId)
                    .getSingleResult();
            Collection<Hire> result = Collections.unmodifiableCollection(
                    session.createQuery("from pl.s13302.carrental.model.Hire where person=:person")
                            .setParameter("person", person)
                            .list()
            );
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public NotFinishedHireDescription countPrice(long hireId) {
        try {
            session.beginTransaction();
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();
            hire.setFinish(LocalDateTime.now(getClock()));
            BigDecimal countedPrice = hire.countPrice();
            long distance = 300L;
            long time = hire.getDuration();
            session.getTransaction().rollback();
            return new NotFinishedHireDescription(countedPrice, distance, time);
        } catch (Exception e) {
            if (session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void releaseCar(Long hireId) {
        try {
            session.beginTransaction();
            Hire hire = (Hire) session.createQuery("from pl.s13302.carrental.model.Hire where id=:hireId")
                    .setParameter("hireId", hireId)
                    .getSingleResult();

            hire.getCar().releaseCar(getClock());
            BigDecimal price = hire.countPrice();

            CreditCard creditCard = hire.getPerson().getCreditCards().toArray(new CreditCard[0])[0];
            creditCard.releaseLock();
            creditCard.charge(price);

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finalizeService() {
        session.close();
    }
}
