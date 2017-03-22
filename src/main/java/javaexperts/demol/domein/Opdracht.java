package javaexperts.demol.domein;

import javax.persistence.*;

@Entity
public class Opdracht {

    public static final String FIND_PLAATS_MET_MEESTE_OPDRACHTEN = "findPlaatsMetMeesteOpdrachten";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String omschrijving;

    @Enumerated(EnumType.STRING)
    private Plaats plaats;

    @ManyToOne
    private Aflevering aflevering;

    public Opdracht() {
    }

    public Opdracht(String omschrijving, Plaats plaats, Aflevering aflevering) {
        this.omschrijving = omschrijving;
        this.plaats = plaats;
        this.aflevering = aflevering;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public Plaats getPlaats() {
        return plaats;
    }

    public Aflevering getAflevering() {
        return aflevering;
    }

}