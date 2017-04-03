package javaexperts.demol.domein;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Opdracht.FIND_PLAATS_MET_MEESTE_OPDRACHTEN
                , query = "select new javaexperts.demol.domein.PlaatsMetAantalOpdrachten(o.plaats, count(o.plaats)) from Opdracht o group by o.plaats order by count(o.plaats) desc")
})
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