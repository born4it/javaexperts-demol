package javaexperts.demol.dao;

import javaexperts.demol.Geavanceerd;
import javaexperts.demol.domein.Antwoord;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class AntwoordDaoTest {

    private static final AntwoordDao ANTWOORD_DAO = new AntwoordDao();

    @AfterClass
    public static void afterTestRun() {
        ANTWOORD_DAO.close();
    }

    @Test
    public void findAntwoordenVanKandidaatInAflevering_Annelies() {
        List<Antwoord> antwoorden =
                ANTWOORD_DAO.findAntwoordenVanKandidaatInAflevering("Annelies", 1);

        assertThat("findAntwoordenVanKandidaatInAflevering: aantal antwoorden incorrect!"
                , antwoorden.size(), equalTo(2));
    }

    @Test
    @Category(Geavanceerd.class)
    public void findCorrecteAntwoordenVanKandidaatInAflevering_Annelies() {
        List<Antwoord> antwoorden =
                ANTWOORD_DAO.findCorrecteAntwoordenVanKandidaatInAflevering("Annelies", 1);

        assertThat("findCorrecteAntwoordenVanKandidaatInAflevering: aantal antwoorden incorrect!"
                , antwoorden.size(), equalTo(2));
    }

    @Test
    @Category(Geavanceerd.class)
    public void findAntwoordenVanKandidaatInAflevering_Davey() {
        List<Antwoord> antwoorden =
                ANTWOORD_DAO.findAntwoordenVanKandidaatInAflevering("Davey", 2);

        assertThat("findAntwoordenVanKandidaatInAflevering: aantal antwoorden incorrect!"
                , antwoorden.size(), equalTo(2));
    }

    @Test
    public void findCorrecteAntwoordenVanKandidaatInAflevering_Davey() {
        List<Antwoord> antwoorden =
                ANTWOORD_DAO.findCorrecteAntwoordenVanKandidaatInAflevering("Davey", 2);

        assertThat("findCorrecteAntwoordenVanKandidaatInAflevering: aantal antwoorden incorrect!"
                , antwoorden.size(), equalTo(0));
    }

}