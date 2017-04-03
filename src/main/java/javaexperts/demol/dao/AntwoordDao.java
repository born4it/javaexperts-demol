package javaexperts.demol.dao;

import javaexperts.demol.domein.Aflevering;
import javaexperts.demol.domein.Antwoord;
import javaexperts.demol.domein.Kandidaat;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class AntwoordDao extends Dao {

    public List<Antwoord> findAntwoordenVanKandidaatInAflevering(String kandidaatVoornaam, int afleveringNummer) {
        TypedQuery<Antwoord> query = entityManager.createNamedQuery(Antwoord.FIND_ANTWOORDEN_VAN_KANDIDAAT_IN_AFLEVERING, Antwoord.class);
        query.setParameter("kandidaatVoornaam", kandidaatVoornaam);
        query.setParameter("afleveringNummer", afleveringNummer);
        return query.getResultList();
    }

    public List<Antwoord> findCorrecteAntwoordenVanKandidaatInAflevering(String kandidaatVoornaam, int afleveringNummer) {
        return findAntwoordenVanKandidaatInAflevering(kandidaatVoornaam, afleveringNummer).stream()
                .filter(Antwoord::isCorrect)
                .collect(Collectors.toList());
    }

}
