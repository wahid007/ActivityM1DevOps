package tn.isett.etudiantservice.etudiant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(etudiantService.saveEtudiant(etudiant));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return etudiant != null ? ResponseEntity.ok(etudiant) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiant() {
        return ResponseEntity.ok(etudiantService.getAllEtudiant());
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiantModif = etudiantService.updateEtudiant(id, etudiant);
        return etudiantModif != null ? ResponseEntity.ok(etudiantModif) : ResponseEntity.notFound().build();
    }

}
