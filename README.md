# Javaexperts opdracht De Mol

In deze opdracht bouwen we functionaliteit om het televisieprogramma De Mol te ondersteunen. Hierbij beperken we ons tot de business en persistence laag.

Het domein model en bijhorende DAOs dienen we te implementeren. Testen voor de DAOs worden aangeleverd en kunnen gebruikt te worden voor feedback en validatie.

Een SQL script is aangeleverd om de tabellen te creëeren en deze met data op te vullen.

## Conventies

### Maven artifact

| | |
| ---------- | ---------------- |
| groupId    | `be.javaexperts` |
| artifactId | `demol`          | 
| version    | `0.1-SNAPSHOT`   | 

### Packages

|                     |                               |
| ------------------- | ----------------------------- |
| Root package        | `be.javaexperts.demol`        |
| Package voor domein | `be.javaexperts.demol.domein` |
| Package voor DAOs   | `be.javaexperts.demol.dao`    |

### Java/JPA

* Primary keys worden gegenereerd door database met strategy IDENTITY
* Field accessors
* Queries moeten named queries zijn

## Plan van aanpak

* Vooraleer te coderen, bestudeer eerst het domein en database model. 
* Maak een nieuw project aan, voeg pom.xml en persistence.xml toe.
* Begin bij het domein model en voorzie de nodige fields, constructors en methoden.
* Breid de klassen in het domein model uit met nodige JPA annotaties zodat het domein model door het database model gecapteerd te worden.
* Ga verder in baby steps, nl. implementeer 1 DAO per keer en neem iedere keer de bijhorende test over.

## Domein model

![Diagram domein model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DomeinModel.png)

### Kandidaat
    
* Een kandidaat wordt uniek geïdentificeerd door id.
* Een kandidaat heeft een voornaam, geboortedatum, woonplaats, beroep, hobbys, beste eigenschap, slechte eigenschap, lievelingseten, identificeert zich met en lievelingsartiest.
* Een kandidaat is eventueel geassocieerd met de aflevering waarin hij/zij vertrokken is.

### Aflevering

* Een aflevering wordt uniek geïdentificeerd door nummer.
* Met iedere aflevering zijn meerder opdrachten geassocieerd.
* Met iedere aflevering zijn meerdere vragen geassocieerd.
* Met iedere aflevering zijn meerdere antwoorden geasocieerd, nl. elke resterende kandidaat beantwoord de vragen.
* Op iedere aflevering wordt de vertrekkende kandidaat bijgehouden.

### Opdracht

* Een opdracht wordt uniek geïdentificeerd door een id.
* Een opdracht heeft een omschrijving en plaats.
* Een opdracht is geassocieerd met zijn bijhorende aflevering.

#### Vraag

* Een vraag is een abstract type en kent GeslotenVraag en KeuzeVraag als concrete subtype.
* Een vraag wordt uniek geïdentificeerd door een id.
* Iedere vraag heeft een vraagstelling en een correct antwoord.

#### GeslotenVraag

* GeslotenVraag is een subtype van Vraag en kan Ja of Nee als correct antwoord hebben.

#### KeuzeVraag

* KeuzeVraag is een subtype van Vraag en heeft meerdere mogelijke antwoorden waarvan één het juiste antwoord is.

### Antwoord

* Een antwoord wordt uniek geïdentificeerd door een id.
* Een antwoord wordt gegeven door een kandidaat in een aflevering op een vraag.
* Het antwoord bevat het eigenlijke antwoord gegeven door de kandidaat.

Opmerking:
In de database wordt niet bijgehouden of antwoord correct is of niet. Bijgevolg kan je geen query schrijven die meteen correcte antwoorden bepaald.

## DAOs

| DAO             | Methode                                          | Gewenst gedrag                                              | Niveau      |
| --------------- | ------------------------------------------------ | ----------------------------------------------------------- | ----------- |
| `AfleveringDao` | `findAlleAfleveringen`                           | Alle afleveringen, oplopend gesorteerd op nummer            | Basis       |
| `AfleveringDao` | `findAfleveringInclusiefVragenMetNummer`         | Aflevering voor nummer waarbij vragen meteen zijn opgehaald | Basis       |
| `AntwoordDao`   | `findAntwoordenVanKandidaatInAflevering`         | Alle antwoorden voor kandidaat in aflevering                | Basis       |
| `KandidaatDao`  | `findKandidaten`                                 | Alle kandidaten                                             | Basis       |
| `AntwoordDao`   | `findCorrecteAntwoordenVanKandidaatInAflevering` | Alle correcte antwoorden voor kandidaat in aflevering       | Geavanceerd |
| `KandidaatDao`  | `findResterendeKandidaten`                       | Alle kandidaten die nog niet vertrokken zijn                | Geavanceerd |
| `OpdrachtDao`   | `findPlaatsMetMeesteOpdrachten`                  | Plaats waar de meeste opdrachten plaatsvonden               | Geavanceerd |
| `VraagDao`      | `findVragenMetAantalKeerGesteld`                 | Vragen en het aantal keer dat deze werden gesteld           | Geavanceerd |


## Database model

![Diagram database model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DatabaseModel.png)