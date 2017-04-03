package javaexperts.demol.dao;

import javaexperts.demol.domein.Aflevering;
import javaexperts.demol.domein.Vraag;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class AfleveringDaoTest {

    private static final AfleveringDao AFLEVERING_DAO = new AfleveringDao();

    @AfterClass
    public static void afterTestRun() {
        AFLEVERING_DAO.close();
    }

    @Test
    public void findAllefleveringen() throws Exception {
        List<Aflevering> afleveringen = AFLEVERING_DAO.findAlleAfleveringen();

        assertThat("findAlleAfleveringen: aantal is incorrect!"
                , afleveringen.size(), equalTo(8));

        IntStream.of(1, afleveringen.size())
                .forEach(i -> assertThat("findAlleAfleveringen: sortering is incorrect!", afleveringen.get(i - 1).getNummer(), equalTo(i)));
    }

    @Test
    public void findAfleveringInclusiefVragenMetNummer_OnevenNummer() {
        Optional<Aflevering> aflevering3 = AFLEVERING_DAO.findAfleveringInclusiefVragenMetNummer(3);

        if (aflevering3.isPresent()) {
            AFLEVERING_DAO.detach(aflevering3.get());

            List<Vraag> vragen = aflevering3.get().getVragen();

            assertThat("findAfleveringInclusiefVragenMetNummer: aantal is incorrect!"
                    , vragen.size(), Matchers.equalTo(2));

            assertThat("findAfleveringInclusiefVragenMetNummer: verschil met verwachte vragen!"
                    , vragen.stream().map(Vraag::getVraagstelling).collect(Collectors.toList())
                    , containsInAnyOrder("Wie is De Mol?", "Zat De Mol in de auto tijdens de opdracht?"));

        } else {
            fail("findAfleveringInclusiefVragenMetNummer: aflevering 3 niet teruggeven!");
        }
    }

    @Test
    public void findAfleveringInclusiefVragenMetNummer_EvenNummer() {
        Optional<Aflevering> aflevering4 = AFLEVERING_DAO.findAfleveringInclusiefVragenMetNummer(4);

        if (aflevering4.isPresent()) {
            AFLEVERING_DAO.detach(aflevering4.get());

            List<Vraag> vragen = aflevering4.get().getVragen();

            assertThat("findAfleveringInclusiefVragenMetNummer: aantal is incorrect!"
                    , vragen.size(), Matchers.equalTo(2));

            assertThat("findAfleveringInclusiefVragenMetNummer: verschil met verwachte vragen!"
                    , vragen.stream().map(Vraag::getVraagstelling).collect(Collectors.toList())
                    , containsInAnyOrder("Wie is De Mol?", "Had De Mol de walkie-talkie tijdens de opdracht?"));

        } else {
            fail("findAfleveringInclusiefVragenMetNummer: aflevering 4 niet teruggeven!");
        }
    }

}