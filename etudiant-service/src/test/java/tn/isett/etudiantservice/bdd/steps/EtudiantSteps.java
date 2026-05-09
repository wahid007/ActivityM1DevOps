// EtudiantSteps.java
package tn.isett.etudiantservice.bdd.steps;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import tn.isett.etudiantservice.etudiant.EtudiantRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class EtudiantSteps {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Given("la base de données contient des étudiants")
    public void laBdContientDesEtudiants() {
        assertThat(etudiantRepository.count()).isGreaterThan(0);
    }

    @When("je récupère la liste des étudiants")
    public void jeRecupereLaListe() {
        // handled by the repository directly in this example
    }

    @Then("la réponse contient au moins {int} étudiant")
    public void laReponseContientAuMoins(int min) {
        assertThat(etudiantRepository.findAll()).hasSizeGreaterThanOrEqualTo(min);
    }
}