package javaexperts.demol.dao;

import javaexperts.demol.Geavanceerd;
import javaexperts.demol.domein.Vraag;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class VraagDaoTest {

    private static final VraagDao VRAAG_DAO = new VraagDao();

    @AfterClass
    public static void afterTestRun() {
        VRAAG_DAO.close();
    }

    @Test
    @Category(Geavanceerd.class)
    public void findVragenMetAantalKeerGesteld() {
        Map<Vraag, Long> vragenEnAantalKeerGesteld = VRAAG_DAO.findVragenMetAantalKeerGesteld();

        vragenEnAantalKeerGesteld.entrySet().forEach(entry -> {
            String vraagstelling = entry.getKey().getVraagstelling();
            long aantalKeerGesteld = entry.getValue();

            switch (vraagstelling) {
                case "Wie is De Mol?":
                    assertThat("findVragenMetAantalKeerGesteld: incorrect aantal keer gesteld voor vraag Wie is De Mol?"
                            , aantalKeerGesteld, equalTo(8L));
                    break;

                case "Had De Mol de walkie-talkie tijdens de opdracht?":
                    assertThat("findVragenMetAantalKeerGesteld: incorrect aantal keer gesteld voor vraag Had De Mol de walkie-talkie tijdens de opdracht?"
                            , aantalKeerGesteld, equalTo(4L));
                    break;

                    case "Zat De Mol in de auto tijdens de opdracht?":
                    assertThat("findVragenMetAantalKeerGesteld: incorrect aantal keer gesteld voor  Zat De Mol in de auto tijdens de opdracht?"
                            , aantalKeerGesteld, equalTo(4L));
                    break;

                default:
                    fail(String.format("findVragenMetAantalKeerGesteld: Onverwachte vraag met vraagstelling %s", vraagstelling));
            }
        });
    }

}
