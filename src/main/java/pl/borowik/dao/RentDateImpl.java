package pl.borowik.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.borowik.model.RentDate;

import javax.persistence.EntityManager;

@Repository
public class RentDateImpl implements RentDateRepository {

    private EntityManager entityManager;

    @Autowired
    public RentDateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void save(RentDate rentDate) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(rentDate);
    }

    @Override
    public RentDate findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        RentDate rentDate = currentSession.get(RentDate.class, theId);

        return rentDate;
    }
}
