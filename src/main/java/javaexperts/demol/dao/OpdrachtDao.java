package javaexperts.demol.dao;

import javaexperts.demol.domein.Opdracht;
import javaexperts.demol.domein.Plaats;
import javaexperts.demol.domein.PlaatsMetAantalOpdrachten;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class OpdrachtDao extends Dao {

    public Optional<Plaats> findPlaatsMetMeesteOpdrachten() {
        TypedQuery<PlaatsMetAantalOpdrachten> query =
                entityManager.createNamedQuery(Opdracht.FIND_PLAATS_MET_MEESTE_OPDRACHTEN, PlaatsMetAantalOpdrachten.class);
        query.setMaxResults(1);

        try {
            return Optional.of(query.getSingleResult().getPlaats());

        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
