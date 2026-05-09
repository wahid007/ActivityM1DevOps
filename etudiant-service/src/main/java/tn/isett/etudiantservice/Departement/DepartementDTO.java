package tn.isett.etudiantservice.Departement;

import lombok.Data;
import tn.isett.etudiantservice.etudiant.Etudiant;

import java.util.List;

@Data
public class DepartementDTO {
    private Long id;
    private String nom;
    private List<Etudiant> etudiants;
    // Add other fields you want to expose to the UI/Client
}