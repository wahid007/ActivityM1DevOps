package tn.isett.etudiantservice.etudiant;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Cacheable("etudiants")
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Cacheable("etudiants")
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id).orElse(null);
        if (existingEtudiant != null) {
            existingEtudiant.setCin(etudiant.getCin());
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setDateNaissance(etudiant.getDateNaissance());
            etudiantRepository.save(existingEtudiant);
        }
        return existingEtudiant;
    }
}
