# servlet-mvn

Exercice pour s'initier à la création de servlets, Maven et l'injection de dépendances.

## Pré-requis

- Maven 3.+
  
  Vérifier que Maven 3.x est installé (le répertoire bin de Maven doit être dans $PATH):
  
  ```
  mvn -version
  # =>
  Apache Maven 3.6.0
  Maven home: /usr/share/maven
  ```
- JDK 8+
  ```
  java -version
  # =>
  openjdk version "11.0.2" 2019-01-15
  ...
  ```


- Intellij


## Déroulement

Chaque étape de l'exercice est présente dans une branche git dédiée (`step-x`) 

Pour la récupérer  executer
```
git checkout -b step-X remotes/origin/step-X
``` 

Avant de récupérer une nouvelle étape, n'oubliez pas de committer en local vos modifications. Pour commiter la solution d'une étape X :

```
git add src/*
git commit -am "Solution step-X"
```


Remarques : 
 - l'étape 1 n'a pas besoin d'être récupérée en local
 - pour l'étape 5, il est nécessaire de récupérer la branche git correspondante car il y a des modifications autres que celles effectuées aux étapes précédentes


## Etapes

### Etape 1

- Initialiser un squelette de projet Maven en ligne de commande :

```
mvn archetype:generate -DgroupId=org.esgi -DartifactId=servlet-mvn -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

- Construire le projet 

```
cd servlet-mvn
mvn clean install
```

 - Voir l'archetype généré (tips : il est sous le répertoire /target)
De quel type est-il ?

### Etape 2

* Créer sous Intellij un nouveau projet à partir de sources existantes et sélectionner le répertoire du projet servlet-mvn


*  Une fois le projet créé, consulter le fichier pom.xml
  
* Modifier le pom.xml afin que le code source et les classes compilées soient en Java 8
  
 *  Ajouter dans le pom.xml le plugin jetty-maven-plugin (groupid:org.eclipse.jetty) en version 9.4.19.v20190610
    * Remarque : Jetty est un serveur "conteneur de servlets", il n'embarque pas toutes les fonctonnalités JEE comme GlassFish par exemple
    * cf https://maven.apache.org/guides/getting-started/index.html#How_do_I_use_plugins  
*  Lancer le serveur Jetty via Maven :
  ```
  mvn jetty:run    
  ``` 

* Bien que l'info "BUILD SUCCESS" est affichée, le serveur Jetty ne se lance pas. Pourquoi ?
    

* Modifier le pom.xml afin que Maven génère une archive WAR pour les serveurs JEE (tips : http://maven.apache.org/pom.html#Maven_Coordinates)

* Relancer le serveur Jetty via Maven et vérifier que le serveur est up (par défaut http://localhost:8080/)

 - Remarque : les classes App est AppTest créées par défaut peuvent être supprimées
