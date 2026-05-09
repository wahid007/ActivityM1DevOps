package tn.isett.etudiantservice.Departement;

import lombok.Data;

@Data
public class DepartementDTO {
    private Long id;
    private String nom;
    // Add other fields you want to expose to the UI/Client
}