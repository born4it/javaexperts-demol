package javaexperts.demol.dao;

import javaexperts.demol.Geavanceerd;
import javaexperts.demol.domein.Kandidaat;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class KandidaatDaoTest {

    private static final KandidaatDao KANDIDAAT_DAO = new KandidaatDao();

    @AfterClass
    public static void afterTestRun() {
        KANDIDAAT_DAO.close();
    }

    @Test
    public void findKandidaten() throws Exception {
        List<Kandidaat> kandidaten = KANDIDAAT_DAO.findKandidaten();

        assertThat("findKandidaten: aantal kandidaten incorrect!", kandidaten.size(), equalTo(kandidaten.size()));

        assertThat("findKandidaten: verschil met verwachte kandidaten!"
                , kandidaten.stream().map(Kandidaat::getVoornaam).collect(Collectors.toList())
                , containsInAnyOrder("Annelies", "Davey", "Eline", "Robin", "Sam"));
    }

    @Test
    @Category(Geavanceerd.class)
    public void findResterendeKandidaten() throws Exception {
        List<Kandidaat> kandidaten = KANDIDAAT_DAO.findResterendeKandidaten();

        assertThat("findResterendeKandidaten: aantal kandidaten incorrect!", kandidaten.size(), equalTo(kandidaten.size()));

        assertThat("findResterendeKandidaten: verschil met verwachte kandidaten!"
                , kandidaten.stream().map(Kandidaat::getVoornaam).collect(Collectors.toList())
                , containsInAnyOrder("Annelies", "Davey", "Eline", "Robin"));
    }

}