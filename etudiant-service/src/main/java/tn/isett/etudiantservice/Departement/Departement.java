package tn.isett.etudiantservice.Departement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import tn.isett.etudiantservice.etudiant.Etudiant; // Import Etudiant

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "departement_seq")
    @SequenceGenerator(name = "departement_seq", sequenceName = "departement_seq", allocationSize = 1)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("departement")  // ← stop here, don't serialize Etudiant.departement
    private List<Etudiant> etudiants;
}
