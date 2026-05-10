# ActivityM1DevOps
Projet multi-composants pour la gestion d'étudiants, composé d'une API backend Spring Boot, d'une application mobile Flutter et d'un environnement d'exécution conteneurisé (PostgreSQL + Redis).

## Vue d'ensemble du projet
- `etudiant-service/` : API REST Java (Spring Boot, Spring Data JPA, PostgreSQL, Redis cache, Actuator, OpenAPI).
- `mobile_app/` : application Flutter (base de projet, UI initiale).
- `docker-compose.yml` : orchestration des services `postgres`, `redis` et `etudiant-service`.
- `.github/pull_request_template.md` : template de PR déjà aligné avec une checklist qualité/sécurité/tests.

## Prérequis
- Docker et Docker Compose
- Java 25 (si exécution locale hors Docker)
- Flutter SDK (si exécution de l'application mobile)

## Démarrage rapide (Docker)
1. Créer un fichier `.env` à la racine avec les variables nécessaires (exemple) :
   - `POSTGRES_DB`
   - `POSTGRES_USER`
   - `POSTGRES_PASSWORD`
   - `ETUDIANT_SERVICE_PORT`
   - `SPRING_DATASOURCE_URL`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
   - `SPRING_REDIS_PORT`
2. Lancer la stack :
   - `docker compose up --build`
3. Vérifier la santé du service :
   - `http://localhost:<ETUDIANT_SERVICE_PORT>/actuator/health`

## Exécution locale du backend (sans Docker)
Depuis `etudiant-service/` :
- Windows : `.\mvnw.cmd spring-boot:run`
- Linux/macOS : `./mvnw spring-boot:run`

## Endpoints principaux
- Étudiants :
  - `POST /api/etudiants`
  - `GET /api/etudiants`
  - `GET /api/etudiants/{id}`
  - `PUT /api/etudiants/{id}`
  - `DELETE /api/etudiants/{id}`
- Départements :
  - `POST /api/departements`
  - `GET /api/departements`
  - `GET /api/departements/{id}`
  - `PUT /api/departements/{id}`
  - `DELETE /api/departements/{id}`
- Observabilité :
  - `GET /actuator/health`
- Documentation API (springdoc) :
  - `GET /swagger-ui/index.html`

## Tests
Depuis `etudiant-service/` :
- Windows : `.\mvnw.cmd test`
- Linux/macOS : `./mvnw test`

Le projet inclut :
- des tests Spring Boot de contexte,
- des scénarios BDD Cucumber (`src/main/resources/features/etudiant.feature`),
- un rapport Cucumber généré dans `target/cucumber-reports/report.html`.

## Convention de review
Les règles suivantes s'appliquent à toutes les Pull Requests de l'équipe :

1. **Délai de review** : toute PR doit recevoir une première review sous **48h maximum**.
2. **Responsable de la review** : l'auteur assigne au moins **1 reviewer** (et **2 reviewers** pour les changements sensibles : sécurité, base de données, infra).
3. **Commentaires bloquants** : tout commentaire marqué bloquant (bug, régression, faille sécurité, non-respect architecture) doit être **résolu avant merge**.
4. **Conversations résolues** : aucune conversation GitHub ne doit rester ouverte au moment du merge.
5. **Qualité automatique obligatoire** : la PR n'est mergée que si la CI est verte (build + tests + checks qualité configurés).
6. **Traçabilité** : chaque PR doit référencer un ticket (ex. Jira) et décrire clairement le *pourquoi*, le *quoi* et le plan de test.
7. **Taille et lisibilité** : privilégier des PR petites et cohérentes (un objectif fonctionnel par PR) pour accélérer la review.
8. **Mise à jour documentaire** : si comportement, API ou configuration changent, la documentation et les variables d'environnement doivent être mises à jour dans la même PR.
9. **Règle d'approbation** : merge autorisé uniquement après approbation explicite d'au moins un reviewer et absence de point bloquant.
10. **Exceptions (hotfix critique)** : en cas d'urgence de production, merge possible avec revue différée, mais une revue complète et une PR de régularisation doivent être faites sous 24h.

## Bonnes pratiques de contribution
- Suivre le template de PR présent dans `.github/pull_request_template.md`.
- Vérifier localement les tests avant ouverture de PR.
- Éviter d'inclure des secrets (tokens, mots de passe, clés) dans le code ou les commits.
