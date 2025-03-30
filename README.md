# TP-SpringBoot-Back

## Prérequis

Avant de démarrer l'application, assurez-vous d'avoir installé Docker et qu'il soit en cours d'exécution.

## Cloner le projet

Pour récupérer le projet en local, utilisez la commande suivante :

```sh
git clone https://github.com/rboudia/TP-SpringBoot-Back.git
```

Puis, accédez au dossier du projet :

```sh
cd TP-SpringBoot-Back
```

## Démarrage de la base de données avec Docker

L'application repose sur une base de données qui doit être lancée via Docker.
Pour ce faire, ouvrez un terminal, placez-vous dans le dossier `docker` du projet et exécutez la commande suivante :

```sh
docker compose up -d
```

Cette commande démarre la base de données en arrière-plan.

Pour arrêter le conteneur de la base de données, utilisez la commande suivante :

```sh
docker compose down
```

## Lancer l'application Spring Boot

Une fois la base de données en cours d'exécution, vous pouvez démarrer l'application Spring Boot.

