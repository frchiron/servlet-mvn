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
