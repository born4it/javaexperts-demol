package javaexperts.demol.dao;

import javaexperts.demol.Geavanceerd;
import javaexperts.demol.domein.Plaats;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class OpdrachtDaoTest {

    private static final OpdrachtDao OPDRACHT_DAO = new OpdrachtDao();

    @AfterClass
    public static void afterTestRun() {
        OPDRACHT_DAO.close();
    }

    @Test
    @Category(Geavanceerd.class)
    public void findPlaatsMetMeesteOpdrachten() {
        Optional<Plaats> plaatsMetMeesteOpdrachten = OPDRACHT_DAO.findPlaatsMetMeesteOpdrachten();

        if (plaatsMetMeesteOpdrachten.isPresent()) {
            assertThat("findPlaatsMetMeesteOpdrachten: verschil met verwachte plaats"
                    , plaatsMetMeesteOpdrachten.get(), equalTo(Plaats.KAAPSTAD));

        } else {
            fail("findPlaatsMetMeesteOpdrachten: plaats niet teruggeven!");
        }
    }

}