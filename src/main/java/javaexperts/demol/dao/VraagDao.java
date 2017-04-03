package javaexperts.demol.dao;

import javaexperts.demol.domein.Aflevering;
import javaexperts.demol.domein.Vraag;
import javaexperts.demol.domein.VraagMetAantalKeerGesteld;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VraagDao extends Dao {

    public Map<Vraag, Long> findVragenMetAantalKeerGesteld() {
        TypedQuery<VraagMetAantalKeerGesteld> query =
                entityManager.createNamedQuery(Vraag.FIND_VRAGEN_MET_AANTAL_KEER_GESTELD, VraagMetAantalKeerGesteld.class);

        return query.getResultList().stream().collect(Collectors.toMap(VraagMetAantalKeerGesteld::getVraag, VraagMetAantalKeerGesteld::getAantalKeerGesteld));
    }

}

