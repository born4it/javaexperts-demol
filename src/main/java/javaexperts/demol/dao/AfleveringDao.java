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

    public Optional<Aflevering> findAfleveringInclusiefVragenMetNummer(int nummer) {
        TypedQuery<Aflevering> query = entityManager.createNamedQuery(Aflevering.FIND_AFLEVERING_EN_VRAGEN_MET_NUMMER, Aflevering.class);
        query.setParameter("nummer", nummer);

        try {
            return Optional.of(query.getSingleResult());

        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
