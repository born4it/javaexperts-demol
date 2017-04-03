package javaexperts.demol.domein;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Antwoord.FIND_ANTWOORDEN_VAN_KANDIDAAT_IN_AFLEVERING
                , query = "select a from Antwoord a where a.kandidaat.voornaam = :kandidaatVoornaam and a.aflevering.nummer = :afleveringNummer")
})
public class Antwoord {

    public static final String FIND_ANTWOORDEN_VAN_KANDIDAAT_IN_AFLEVERING = "findAntwoordenVanKandidaatInAflevering";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Aflevering aflevering;

    @OneToOne
    private Kandidaat kandidaat;

    @OneToOne
    private Vraag vraag;

    private String antwoord;

    public Antwoord() {
    }

    public Antwoord(Aflevering aflevering, Kandidaat kandidaat, Vraag vraag, String antwoord) {
        this.aflevering = aflevering;
        this.kandidaat = kandidaat;
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public Kandidaat getKandidaat() {
        return kandidaat;
    }

    public Aflevering getAflevering() {
        return aflevering;
    }

    public Vraag getVraag() {
        return vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public boolean isCorrect() {
        return getVraag().isAntwoordCorrect(this);
    }

}

