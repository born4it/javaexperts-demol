package javaexperts.demol.dao;

import javaexperts.demol.domein.Aflevering;
import javaexperts.demol.domein.Kandidaat;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class KandidaatDao extends Dao {

    public List<Kandidaat> findKandidaten() {
        return entityManager.createNamedQuery(Kandidaat.FIND_KANDIDATEN, Kandidaat.class).getResultList();
    }

    public List<Kandidaat> findResterendeKandidaten() {
        return entityManager.createNamedQuery(Kandidaat.FIND_RESTERENDE_KANDIDATEN, Kandidaat.class).getResultList();
    }

}
