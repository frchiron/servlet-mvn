# servlet-mvn

Exercice pour s'initier à la création de servlets, Maven et l'injection de dépendances.

## Pré-requis

- Maven 3.+
- JDK 8+
- Intellij


## Déroulement

Chaque étape de l'exercice est présente dans une branche git dédiée (`step-x`) 



Pour la récupérer  executer
```
git checkout -b stepX remotes/origin/stepX
``` 

NOTE : L'étape 1 n'a pas besoin d'être récupérée en local

Avant de récupérer une nouvelle étape, n'oubliez pas de committer en local vos modifications. Pour commiter la solution d'une étape X :

```
git add src/*
git commit -am "Solution stepX"
```


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
