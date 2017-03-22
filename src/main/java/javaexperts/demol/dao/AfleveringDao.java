package javaexperts.demol.dao;

import javaexperts.demol.domein.Aflevering;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AfleveringDao extends Dao {

    public void detach(Aflevering aflevering) {
        entityManager.detach(aflevering);
    }

    public List<Aflevering> findAlleAfleveringen() {
        return entityManager.createNamedQuery(Aflevering.FIND_ALLE_AFLEVERINGEN, Aflevering.class)
                .getResultList();
    }

}
