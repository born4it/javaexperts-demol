package javaexperts.demol.domein;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GESLOTEN")
public class GeslotenVraag extends Vraag {

    public GeslotenVraag() {
    }

    public GeslotenVraag(String vraagstelling, boolean correctAntwoord) {
        super(vraagstelling, Boolean.toString(correctAntwoord));
    }

}
