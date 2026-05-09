package tn.isett.etudiantservice.etudiant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.isett.etudiantservice.Departement.Departement; // Import Departement

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "etudiant_seq")
    @SequenceGenerator(name = "etudiant_seq", sequenceName = "etudiant_seq", allocationSize = 1)
    private Long id;
    private String cin;
    private String nom;
    private LocalDate dateNaissance;
    private String email;
    private LocalDate anneePremiereInscription;

    @ManyToOne
    @JoinColumn(name = "departement_id") // This specifies the foreign key column
    @JsonIgnoreProperties("etudiants")   // ← stop here, don't serialize Departement.etudiants
    private Departement departement; // Add the ManyToOne relationship

    public int age() {
        return Period.between(this.dateNaissance, LocalDate.now()).getYears();
    }
}
