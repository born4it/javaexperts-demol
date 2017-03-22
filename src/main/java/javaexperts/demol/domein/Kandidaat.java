package javaexperts.demol.domein;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
public class Kandidaat {

    public static final String FIND_KANDIDATEN = "findKandidaten";
    public static final String FIND_RESTERENDE_KANDIDATEN = "findResterendeKandidaten";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String voornaam;

    @OneToOne(mappedBy = "vertrekkendeKandidaat")
    private Aflevering vertrokkenIn;

    @Temporal(TemporalType.DATE)
    private Date geboortedatum;

    private String woonplaats;

    private String beroep;

    private String hobbys;

    @Column(name = "beste_eigenschap")
    private String besteEigenschap;

    @Column(name = "slechts_eigenschap")
    private String slechteEigenschap;

    private String lievelingseten;

    @Column(name = "identificeert_zich_met")
    private String identificeertZichMet;

    private String lievelingsartiest;

    public Kandidaat() {
    }

    public Kandidaat(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public Optional<Aflevering> getVertrokkenIn() {
        return Optional.ofNullable(vertrokkenIn);
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getBeroep() {
        return beroep;
    }

    public String getHobbys() {
        return hobbys;
    }

    public String getBesteEigenschap() {
        return besteEigenschap;
    }

    public String getSlechteEigenschap() {
        return slechteEigenschap;
    }

    public String getLievelingseten() {
        return lievelingseten;
    }

    public String getIdentificeertZichMet() {
        return identificeertZichMet;
    }

    public String getLievelingsartiest() {
        return lievelingsartiest;
    }

    public void setVertrokkenIn(Aflevering vertrokkenIn) {
        this.vertrokkenIn = vertrokkenIn;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public void setBesteEigenschap(String besteEigenschap) {
        this.besteEigenschap = besteEigenschap;
    }

    public void setSlechteEigenschap(String slechtsEigenschap) {
        this.slechteEigenschap = slechtsEigenschap;
    }

    public void setLievelingseten(String lievingseten) {
        this.lievelingseten = lievingseten;
    }

    public void setIdentificeertZichMet(String identificeertZichMet) {
        this.identificeertZichMet = identificeertZichMet;
    }

    public void setLievelingsartiest(String lievelingsartiest) {
        this.lievelingsartiest = lievelingsartiest;
    }

}