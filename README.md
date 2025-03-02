# TP EVAL ORM - PetStore

TP Eval – ORM – JPA – Hibernate

## Pour commencer

### Besoin de:

- Java 17
- MySQL...
- Maven ou wrapper Maven

### Installation rapide

1. Créez une base de données MySQL nommée `petstore`
2. Vérifiez que MySQL est installé et en cours d'exécution
2. Vérifiez que vous pouvez vous connecter avec l'utilisateur `root` sans mot de passe (ou modifiez persistence.xml)

## Lancement

### Option 1 : IDE

Ouvrez le projet et lancez la classe `fr.petstore.app.Main` présent dans FR !!!.

### Option 2 : Terminal

```
# Compiler
.\mvnw.cmd clean compile

# Copier les dépendances
.\mvnw.cmd dependency:copy-dependencies

# Lancer
java -cp "target/classes;target/dependency/*" fr.petstore.app.Main
```

## Ce que fait le programme

Le programme utilise Hibernate pour :
- Créer automatiquement la base de données et les tables
- Insérer des données d'exemple : une animalerie, des produits et des animaux
- Exécuter une requête JPQL pour récupérer et afficher les animaux

## Architecture du projet

Le projet suit une architecture en couches simplifiée :

1. **Couche Modèle** (`fr.petstore.model`) : Contient les entités JPA (Animal, Cat, Fish, PetStore, etc.)
2. **Couche DAO** (`fr.petstore.dao`) : Contient les classes d'accès aux données
3. **Couche Service** (`fr.petstore.service`) : Contient la logique métier
4. **Couche Application** (`fr.petstore.app`) : Point d'entrée de l'application

## Remarques

- Les tables sont recréées à chaque lancement (mode `create` dans persistence.xml)
- Pour garder la data switch en mode `update`
