package javaexperts.demol;

import javaexperts.demol.dao.Dao;
import javaexperts.demol.domein.*;

import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PopuleerDatabase extends Dao {

    public static void main(String[] args) throws IOException {
        new PopuleerDatabase().populeer();
    }

    public void populeer() throws IOException {
        try {
            populeerVragen();
            populeerAfleveringen();
            populeerOpdrachten();
            populeerKandidaten();

            toekennenVragenEnAntwoordenAanAfleveringen();

        } finally {
            close();
        }
    }

    private void toekennenVragenEnAntwoordenAanAfleveringen() {
        List<Aflevering> afleveringen =
                entityManager.createQuery("select a from Aflevering as a", Aflevering.class).getResultList();

        List<Kandidaat> kandidaten =
                entityManager.createQuery("select k from Kandidaat as k", Kandidaat.class).getResultList();

        List<Vraag> vragen =
                entityManager.createQuery("select v from Vraag as v order by v.vraagstelling", Vraag.class).getResultList();

        for (Aflevering aflevering : afleveringen) {
            List<Vraag> vragenVoorAflevering = new ArrayList<>();
            List<Antwoord> antwoordenVanAflevering = new ArrayList<>();


            if (aflevering.getNummer() % 2 == 0) {
                // Even aflevering
                vragenVoorAflevering.addAll(Arrays.asList(vragen.get(1), vragen.get(0)));

            } else {
                // Oneven aflevering
                vragenVoorAflevering.addAll(Arrays.asList(vragen.get(1), vragen.get(2)));
            }

            /*
                Robin = De Mol
                Annelies = Juist
                Davey = Niet just
                Eline = Niet just
            */
            for (Vraag vraag : vragenVoorAflevering) {
                for (Kandidaat kandidaat : kandidaten) {
                    String antwoord = "Foutief";

                    if (kandidaat.getVoornaam().equals("Annelies")) {
                        antwoord = vraag.getCorrectAntwoord();
                    }

                    antwoordenVanAflevering.add(new Antwoord(aflevering, kandidaat, vraag, antwoord));
                }
            }

            aflevering.addVragen(vragenVoorAflevering);
            aflevering.addAntwoorden(antwoordenVanAflevering);
        }

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
    }

    public void populeerAfleveringen() {
        List<Aflevering> afleveringen =
                IntStream.range(1, 9)
                        .mapToObj(i -> {
                            Aflevering aflevering = new Aflevering();
                            aflevering.setNummer(i);
                            return aflevering;
                        })
                        .collect(Collectors.toList());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        afleveringen.forEach(aflevering -> entityManager.persist(aflevering));
        tx.commit();
    }

    public void populeerOpdrachten() {
        List<Aflevering> afleveringen =
                entityManager.createQuery("select a from Aflevering as a", Aflevering.class).getResultList();

        for (int i = 0; i < afleveringen.size(); ++i) {
            Aflevering aflevering = afleveringen.get(i);

            Plaats plaats;
            if (i == 1) {
                plaats = Plaats.ANTWERPEN;
            } else if (i <= 6) {
                plaats = Plaats.KAAPSTAD;
            } else {
                plaats = Plaats.JOHANNESBURG;
            }

            aflevering.addOpdrachten(Collections.singletonList(new Opdracht("Opdracht", plaats, aflevering)));
        }

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        tx.commit();
    }

    public void populeerKandidaten() throws IOException {
        final Path imagesRoot = Paths.get("src\\main\\resources\\images");

        List<Kandidaat> kandidaten = new ArrayList<>();

        Kandidaat sam = new Kandidaat("Sam");
        sam.setBeroep("Showroomadviseur");
        sam.setGeboortedatum(Date.from(LocalDate.of(1992, 7, 2).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        sam.setWoonplaats("Hamont-Achel");
        sam.setHobbys("Joggen, bowlen, jetskiën, wakeboarden, denkspelletjes, kubben");
        sam.setBesteEigenschap("Sociaal");
        sam.setSlechteEigenschap("Uitstelgedrag");
        sam.setLievelingseten("Spaghetti vongole");
        sam.setIdentificeertZichMet("Hond");
        sam.setLievelingsartiest("Flogging Molly");
        kandidaten.add(sam);

        Kandidaat annelies = new Kandidaat("Annelies");
        annelies.setBeroep("Leerkracht godsdienst");
        annelies.setGeboortedatum(Date.from(LocalDate.of(1958, 4, 19).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        annelies.setWoonplaats("Schoten");
        annelies.setHobbys("Koken, feestjes geven, organiseren van kwissen");
        annelies.setBesteEigenschap("Hulpvaardig");
        annelies.setSlechteEigenschap("Overdrijven");
        annelies.setLievelingseten("Salades (Griekse, niçoise)");
        annelies.setLievelingsartiest("Bruce Springsteen");
        kandidaten.add(annelies);

        Kandidaat davey = new Kandidaat("Davey");
        davey.setBeroep("Houtbewerker");
        davey.setGeboortedatum(Date.from(LocalDate.of(1988, 3, 7).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        davey.setWoonplaats("Onze-Lieve-Vrouw-Waver");
        davey.setHobbys("Moto's, interieur, muziek, festivals");
        davey.setBesteEigenschap("Oprechtheid");
        davey.setSlechteEigenschap("Oprechtheid");
        davey.setLievelingseten("Pistolets");
        davey.setIdentificeertZichMet("Tonijn");
        davey.setLievelingsartiest("Ryan Adams");
        kandidaten.add(davey);

        Kandidaat eline = new Kandidaat("Eline");
        eline.setBeroep("Politie-inspecteur");
        eline.setGeboortedatum(Date.from(LocalDate.of(1992, 4, 24).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        eline.setWoonplaats("Overmere");
        eline.setHobbys("Voetbal, sport algemeen, monitor out of limits");
        eline.setBesteEigenschap("Assertief");
        eline.setSlechteEigenschap("Onverdraagzaam");
        eline.setLievelingseten("Frieten met steak en pepersaus");
        eline.setIdentificeertZichMet("Labrador");
        eline.setLievelingsartiest("Ed Sheeran");
        kandidaten.add(eline);

        Kandidaat robin = new Kandidaat("Robin");
        robin.setBeroep("Laborant");
        robin.setGeboortedatum(Date.from(LocalDate.of(1973, 6, 29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        robin.setWoonplaats("Holsbeek");
        robin.setHobbys("Tennis, basketbal, lopen");
        robin.setBesteEigenschap("Ondernemend");
        robin.setSlechteEigenschap("Snel ontgoocheld in iemand");
        robin.setLievelingseten("Pasta");
        robin.setIdentificeertZichMet("Giraf");
        robin.setLievelingsartiest("INXS");
        kandidaten.add(robin);

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        kandidaten.forEach(kandidaat -> entityManager.persist(kandidaat));

        Aflevering aflevering6 = entityManager.createQuery("select a from Aflevering a where a.nummer = 6", Aflevering.class).getSingleResult();
        aflevering6.setVertrekkendeKandidaat(sam);

        tx.commit();
    }

    public void populeerVragen() {
        populeerGeslotenVragen();
        populeerKeuzeVragen();
    }

    public void populeerGeslotenVragen() {
        List<GeslotenVraag> geslotenVragen = Arrays.asList(
            new GeslotenVraag("Had De Mol de walkie-talkie tijdens de opdracht?", false),
            new GeslotenVraag("Zat De Mol in de auto tijdens de opdracht?", true)
        );

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        geslotenVragen.forEach(geslotenVraag -> entityManager.persist(geslotenVraag));
        tx.commit();
    }

    public void populeerKeuzeVragen() {
        List<String> kandidaatVoornamen =
                entityManager.createQuery("select voornaam from Kandidaat", String.class)
                        .getResultList();

        List<KeuzeVraag> keuzeVragen = Arrays.asList(
                new KeuzeVraag("Wie is De Mol?", "Robin", kandidaatVoornamen)
        );

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        keuzeVragen.forEach(keuzeVraag -> entityManager.persist(keuzeVraag));
        tx.commit();
    }

}
