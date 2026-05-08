package tn.isett.etudiantservice.etudiant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

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
