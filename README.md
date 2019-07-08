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

### Etape 1 : Initialisation du projet

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

### Etape 2 : Mise en place du serveur Jetty

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

* Bien que l'info "BUILD SUCCESS" soit affichée, le serveur Jetty ne se lance pas. Pourquoi ?
    

* Modifier le pom.xml afin que Maven génère une archive WAR pour les serveurs JEE (tips : http://maven.apache.org/pom.html#Maven_Coordinates)

* Relancer le serveur Jetty via Maven et vérifier que le serveur est up (par défaut http://localhost:8080/)

* Lancer la génération du WAR avec Maven :
  ```
  mvn clean package
  ``` 


* Compléter le projet en créant un fichier de déploiement  d'archive WAR :
    * Créer sous src/main/webapp/WEB-INF un fichier web.xml avec le contenu suivant :
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
    </web-app>
    ```
* Relancer la génération et vérifier que le war est bien créé    

### Etape 3: Création d'une servlet

* Créer une servlet BookServlet par annotation qui répond à l'url /book

    * La servlet doit étendre la classe HttpServlet

    * Par défaut la classe HttpServlet n'est pas trouvée, il faut rajouter dans le pom.xml la dépendance javaee-web-api en version 8.0
    
    * L'annotation @WebServlet permet de déclarer des servlets (see https://docs.oracle.com/javaee/7/api/javax/servlet/annotation/WebServlet.html)

* Ajouter la méthode doGet (tips : reprendre la signature de HttpServlet) et rajouter un `System.out.println` pour vérifier la bonne exécution de la servlet

* Lancer Jetty et vérifier que la servlet est exécutée :
    * vérifier la bonne exécution avec l'url : http://localhost:8080/book et la console Intellij

```
mvn jetty:run
```


### Etape 4 : Exemple de conflit sur les dépendances

* (Re)lancer Jetty via Maven :
```
mvn jetty:run
```


Les logs affichent plusieurs warnings concernant la classe Servlet. 

 La classe Servlet est en effet présente dans la dépendance javaee-web-api  que nous avons rajouté et dans le serveur Jetty (qui est un conteneur de servlets). 

Afin d'éviter toute ambiguité à l'exécution de l'application, Maven permet d'exclure une dépendance à l'exécution, cf https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Scope)

* Modifier le pom.xml en conséquence en rajoutant le scope nécessaire (`<scope>...</scope>`) pour la dépendance javaee-web-api

* Re-lancer Jetty et vérifier qu'il n'y a plus de warnings :
`mvn jetty:run`

### Etape 5 : Injection de dépendances

* Jetty étant un conteneur de servlet, nous avons besoin de rajouter une fonctionnalité de CDI (Context & Depencies Injection). Dans le pom.xml rajouter la dépendances
weld-servlet en version 2.4.8.Final (voir https://mvnrepository.com)

Pour info le projet a également été complété avec des fichiers de configuration sous WEB-INF pour l'injection de dépendances.


* Compléter la méthode doGet afin d'afficher dans le navigateur le titre du livre correpond à l'id passé en paramètre. (exemple : http://localhost:8080/book?id=1), en injectant le service BookService (utilisation de @Inject)



* Exécuter l'application via `mvn jetty:run`





