package javaexperts.demol.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("KEUZE")
public class KeuzeVraag extends Vraag {

    @ElementCollection
    @CollectionTable(name = "KeuzeVraagAntwoorden", joinColumns = { @JoinColumn(name = "keuzevraag_id") })
    @Column(name = "antwoord")
    private List<String> mogelijkeAntwoorden = new ArrayList<String>();

    public KeuzeVraag() {
    }

    public KeuzeVraag(String vraagstelling, String correctAntwoord, List<String> mogelijkeAntwoorden) {
        super(vraagstelling, correctAntwoord);
        this.mogelijkeAntwoorden = mogelijkeAntwoorden;
    }

    public List<String> getMogelijkeAntwoorden() {
        return mogelijkeAntwoorden;
    }

}
