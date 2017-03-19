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

* Voor te coderen, bestudeer eerst het domein en database model. 
* Maak een nieuw project aan, voeg pom.xml en persistence.xml toe.
* Begin bij het domein model en voorzie de nodige fields, constructors en methods.
* Breid de klassen in het domein model uit met nodige JPA annotaties zodat het domein model door het database model gecapteerd te worden.
* Implementeer de DAOs en gebruik hierbij de aangeleverde testen om de codebase te valideren.@

## Domein model

![Diagram domein model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DomeinModel.png)

## Database model

![Diagram database model](https://raw.githubusercontent.com/born4it/javaexperts-demol/master/images/DeMol-DatabaseModel.png)