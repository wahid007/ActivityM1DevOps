## 📝 Description du changement
<!-- Décris le POURQUOI, puis le QUOI (impact métier, impact technique, zones touchées). -->

## 🎫 Ticket / traçabilité
Ticket : [PROJ-XXX](https://your-org.atlassian.net/browse/PROJ-XXX)
<!-- Toute PR doit être liée à un ticket. -->

## 🔀 Type de changement
- [ ] 🐛 Correction de bug
- [ ] 🚀 Nouvelle fonctionnalité
- [ ] ♻️ Refactoring (pas de changement fonctionnel)
- [ ] 📦 Mise à jour de dépendances
- [ ] 🔧 Configuration / CI/CD
- [ ] 📝 Documentation uniquement

## ⚠️ Niveau de sensibilité
- [ ] Changement standard
- [ ] Changement sensible (sécurité / base de données / infrastructure)

## 🧪 Plan de test
<!-- Décris précisément comment valider la PR (étapes, commandes, cas testés, preuves). -->

## 🚦 Convention de review — Conditions de merge (OBLIGATOIRES)
> Cette PR ne doit pas être mergée tant que toutes les cases obligatoires ci-dessous ne sont pas cochées.

### 1) SLA de review et assignation
- [ ] Date/heure d'ouverture de la PR renseignée : `YYYY-MM-DD HH:mm`
- [ ] Date/heure limite de première review (+48h) renseignée : `YYYY-MM-DD HH:mm`
- [ ] Au moins 1 reviewer est assigné
- [ ] Si changement sensible : au moins 2 reviewers sont assignés

### 2) Blocants et conversations
- [ ] Tous les commentaires bloquants sont résolus avant merge
- [ ] Toutes les conversations de review sont résolues avant merge

### 3) Qualité automatique
- [ ] CI verte (build, tests, checks qualité)
- [ ] Le code compile sans erreur
- [ ] Les tests pertinents passent (unitaires/intégration/BDD selon le scope)
- [ ] Aucune violation linter/Sonar bloquante

### 4) Documentation et configuration
- [ ] README/documentation mis à jour si comportement, API ou config modifiés
- [ ] Endpoints/API modifiés documentés (Swagger/OpenAPI)
- [ ] Variables d'environnement ajoutées/modifiées reportées dans `.env.example` (ou doc équivalente)

### 5) Approbation finale
- [ ] Au moins 1 approbation explicite d'un reviewer est présente
- [ ] Aucun point bloquant restant au moment du merge

## 🚨 Exception hotfix critique (à utiliser uniquement si nécessaire)
- [ ] Cette PR est un hotfix critique de production
- [ ] Une revue complète différée est planifiée sous 24h (lien ticket/PR de régularisation) : ________

## 📎 Preuves (facultatif mais recommandé)
<!-- Captures d'écran, logs CI, extraits de tests, métriques, etc. -->

## 💬 Notes pour les reviewers
<!-- Points de vigilance, compromis techniques, dettes connues, zones à inspecter en priorité. -->
