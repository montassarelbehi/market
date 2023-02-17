# Market API

Une partie du métier est de vendre de l'énergie sur plusieurs marchés(Primaire, Secondaire et Rapide). 
Sur chacun de ces marchés peut placer une offre composée de plusieurs "blocs" horaires (une journée de 24h pourrait contenir 8 blocs de 3 heures). 

Chaque bloc horaire présente :
 - la quantité d'énergie (en MW) qui sera produite
 - un prix plancher au-dessous duquel on ne vendra pas.

Les parcs producteurs d'électricité(solaires, éoliens ou hydrauliques), sont capables de fournir un certain nombre de MégaWatt pendant la durée d'un bloc horaire. 

On doit pouvoir connaître les parcs qui vont produire l'électricité d'une offre.

Nous vous demandons d'implémenter les APIs permettant de :
 - créer une offre
 - créer un parc
 - lister les offres proposées par Agregio pour chaque marché
 - liste les parcs qui vendent sur un marché.

## How to run
- Language = Java 11 (java -jar market-1.0.0-SNAPSHOT.jar)
- Build = Maven.
- Datasource = H2 In Memory (http://localhost:8080/market-api/h2-console)
- ITs : mvn clean install.
- E2E: Swagger (http://localhost:8080/market-api/swagger-ui/index.html)
