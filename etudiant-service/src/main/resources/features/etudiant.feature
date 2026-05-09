# src/test/resources/features/etudiant.feature
Feature: Gestion des étudiants

  Scenario: Récupérer tous les étudiants
    Given la base de données contient des étudiants
    When je récupère la liste des étudiants
    Then la réponse contient au moins 1 étudiant