package javaexperts.demol.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Aflevering.FIND_ALLE_AFLEVERINGEN
                , query = "select a from Aflevering as a order by a.nummer")
})
public class Aflevering {

    public static final String FIND_ALLE_AFLEVERINGEN = "findAlleAfleveringen";
    public static final String FIND_AFLEVERING_EN_VRAGEN_MET_NUMMER = "findAfleveringInclusiefVragenMetNummer";

    @Id
    private int nummer;

    @OneToMany(mappedBy = "aflevering", cascade = CascadeType.PERSIST)
    private List<Opdracht> opdrachten = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name="aflevering_id"), inverseJoinColumns = @JoinColumn(name="vraag_id"))
    @OrderColumn(name = "volgorde")
    private List<Vraag> vragen = new ArrayList<>();

    @OneToMany(mappedBy = "aflevering", cascade = CascadeType.PERSIST)
    private List<Antwoord> antwoorden = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "vertrekkende_kandidaat_id")
    private Kandidaat vertrekkendeKandidaat;

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public List<Opdracht> getOpdrachten() {
        return opdrachten;
    }

    public void addOpdrachten(List<Opdracht> opdrachten) {
        this.opdrachten.addAll(opdrachten);
    }

    public List<Vraag> getVragen() {
        return vragen;
    }

    public void addVragen(List<Vraag> vragen) {
        this.vragen.addAll(vragen);
    }

    public List<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public void addAntwoorden(List<Antwoord> antwoorden) {
        this.antwoorden.addAll(antwoorden);
    }

    public Kandidaat getVertrekkendeKandidaat() {
        return vertrekkendeKandidaat;
    }

    public void setVertrekkendeKandidaat(Kandidaat vertrekkendeKandidaat) {
        this.vertrekkendeKandidaat = vertrekkendeKandidaat;
    }
}