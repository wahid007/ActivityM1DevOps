package tn.isett.etudiantservice.etudiant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
}
