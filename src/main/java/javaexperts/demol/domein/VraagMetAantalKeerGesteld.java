package javaexperts.demol.domein;


public class VraagMetAantalKeerGesteld {

    private Vraag vraag;

    private long aantalKeerGesteld;

    public VraagMetAantalKeerGesteld(Vraag vraag, long aantalKeerGesteld) {
        this.vraag = vraag;
        this.aantalKeerGesteld = aantalKeerGesteld;
    }

    public Vraag getVraag() {
        return vraag;
    }

    public long getAantalKeerGesteld() {
        return aantalKeerGesteld;
    }

}
