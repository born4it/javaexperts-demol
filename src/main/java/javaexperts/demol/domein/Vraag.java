package javaexperts.demol.domein;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "soort")
@NamedQueries({
        @NamedQuery(name = Vraag.FIND_VRAGEN_MET_AANTAL_KEER_GESTELD
                , query = "select new javaexperts.demol.domein.VraagMetAantalKeerGesteld(v, count(v)) from Aflevering a join a.vragen v group by v")
})
public abstract class Vraag {

    public static final String FIND_VRAGEN_MET_AANTAL_KEER_GESTELD = "findVragenMetAantalKeerGesteld";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vraagstelling;

    @Column(name = "correct_antwoord")
    private String correctAntwoord;

    public Vraag() {
    }

    public Vraag(String vraagstelling, String correctAntwoord) {
        this.vraagstelling = vraagstelling;
        this.correctAntwoord = correctAntwoord;
    }

    public boolean isAntwoordCorrect(Antwoord antwoord) {
        return correctAntwoord.equals(antwoord.getAntwoord());
    }

    public String getVraagstelling() {
        return vraagstelling;
    }

    public String getCorrectAntwoord() {
        return correctAntwoord;
    }

}