package javaexperts.demol.domein;

public class PlaatsMetAantalOpdrachten {

    private Plaats plaats;
    private long aantalOpdrachten;

    public PlaatsMetAantalOpdrachten(Plaats plaats, long aantalOpdrachten) {
        this.plaats = plaats;
        this.aantalOpdrachten = aantalOpdrachten;
    }

    public Plaats getPlaats() {
        return plaats;
    }

    public long getAantalOpdrachten() {
        return aantalOpdrachten;
    }

}