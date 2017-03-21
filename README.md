# Javaexperts opdracht De Mol

In deze opdracht bouwen we functionaliteit om het televisieprogramma De Mol te ondersteunen. Hierbij beperken we ons tot het domein model en de persistentie laag.

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

* Primary keys worden gegenereerd door de database met strategy IDENTITY
* Field accessors
* Alle queries moeten named queries zijn

### Maven dependencies

Gebruik van volgende Maven dependencies is noodzakelijk:

| groupId       | artificatId             | versionId   | scope |
| ------------- | ----------------------- |------------ | ----- |
| org.hibernate | hibernate-entitymanager | 5.2.8.Final |       |
| mysql         | mysql-connector-java    | 6.0.6       |       |
| junit         | junit                   | 4.12        | test  |
| org.hamcrest  | hamcrest-all            | 1.3         | test  |

## Plan van aanpak

* Vooraleer te coderen, bestudeer eerst het domein en database model. 
* Maak een nieuw project aan, voeg pom.xml en persistence.xml toe.
* Download [OpdrachtDeMol.zip](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/OpdrachtDeMol.zip) en zet de files in de juiste directories.
* Voer DeMol-Database-Dump.sql op jullie eigen database uit.
* Begin bij het domein model en voorzie de nodige fields, constructors en methoden. Baseer je hiervoor op de klasse PopuleerDatabase.
* Breid de klassen in het domein model uit met de nodige JPA annotaties zodat het domein model gemapped kan worden op het database model en vice versa.
* Implementeer de verschillende DAOs. Doe dit in baby steps, t.t.z. 1 DAO en bijhoren test en eventueel test methode per keer.

## Conceptueel

![Conceptueel Diagram](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-Conceptueel.png)

## Domein model

![Diagram domein model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DomeinModel.png)

### Kandidaat
    
* Een kandidaat wordt uniek geïdentificeerd door id.
* Een kandidaat heeft een voornaam, geboortedatum, woonplaats, beroep, hobbys, beste eigenschap, slechte eigenschap, lievelingseten, identificeert zich met en lievelingsartiest.
* Een kandidaat is eventueel geassocieerd met de aflevering waarin hij/zij vertrokken is.

### Aflevering

* Een aflevering wordt uniek geïdentificeerd door nummer.
* Met iedere aflevering zijn meerdere opdrachten geassocieerd.
* Met iedere aflevering zijn meerdere vragen geassocieerd.
* Met iedere aflevering zijn meerdere antwoorden geassocieerd, nl. antwoorden van elke resterende kandidaat op de vragen voor deze aflevering.
* Op iedere aflevering wordt de vertrekkende kandidaat bijgehouden.

### Opdracht

* Een opdracht wordt uniek geïdentificeerd door id.
* Een opdracht heeft een omschrijving en plaats.
* Een opdracht is geassocieerd met zijn bijhorende aflevering.

#### Vraag

* Een vraag is een abstract type en kent GeslotenVraag en KeuzeVraag als concrete subtypes.
* Een vraag wordt uniek geïdentificeerd door id.
* Iedere vraag heeft een vraagstelling en een correct antwoord.

#### GeslotenVraag

* GeslotenVraag is een subtype van Vraag en kan Ja of Nee als correct antwoord hebben.

#### KeuzeVraag

* KeuzeVraag is een subtype van Vraag en heeft meerdere mogelijke antwoorden waarvan één het juiste antwoord is.

### Antwoord

* Een antwoord wordt uniek geïdentificeerd door id.
* Een antwoord wordt gegeven door een kandidaat in een aflevering op een vraag.
* Het antwoord bevat het eigenlijke antwoord gegeven door de kandidaat.

Merk op dat in de database niet wordt bijgehouden of antwoord correct is of niet. Bijgevolg kan je geen query schrijven die correcte antwoorden direct op de database filtert.

## DAOs

De DAOs moeten minimaal onderstaande functionaliteit aanleveren. Je kan de DAOs eventueel zelf uitbreiden met eigen testen die je feedback geven tijdens het uitwerken van het domein model.

| DAO             | Methode                                          | Gewenst gedrag                                              | Niveau      |
| --------------- | ------------------------------------------------ | ----------------------------------------------------------- | ----------- |
| `AfleveringDao` | `findAlleAfleveringen`                           | Alle afleveringen, oplopend gesorteerd op nummer            | Basis       |
| `AfleveringDao` | `findAfleveringInclusiefVragenMetNummer`         | Aflevering met nummer waarbij vragen meteen zijn opgehaald  | Basis       |
| `AntwoordDao`   | `findAntwoordenVanKandidaatInAflevering`         | Alle antwoorden voor kandidaat in aflevering                | Basis       |
| `KandidaatDao`  | `findKandidaten`                                 | Alle kandidaten                                             | Basis       |
| `AntwoordDao`   | `findCorrecteAntwoordenVanKandidaatInAflevering` | Alle correcte antwoorden voor kandidaat in aflevering       | Geavanceerd |
| `KandidaatDao`  | `findResterendeKandidaten`                       | Alle kandidaten die nog niet vertrokken zijn                | Geavanceerd |
| `OpdrachtDao`   | `findPlaatsMetMeesteOpdrachten`                  | Plaats waar de meeste opdrachten plaatsvond                 | Geavanceerd |
| `VraagDao`      | `findVragenMetAantalKeerGesteld`                 | Vragen en het aantal keer dat deze werden gesteld           | Geavanceerd |

## Database model

![Diagram database model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DatabaseModel.png)
