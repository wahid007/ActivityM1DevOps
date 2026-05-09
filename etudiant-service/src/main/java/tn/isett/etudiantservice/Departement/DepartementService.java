package tn.isett.etudiantservice.Departement;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class DepartementService {
    private  DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @CacheEvict(value = "departements", allEntries = true)
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Cacheable("departements")
    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Cacheable("departements")
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @CacheEvict(value = "departements", allEntries = true)
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @CacheEvict(value = "departements", allEntries = true)
    public Departement updateDepartement(Long id, Departement departement) {
        Departement existingDepartement = departementRepository.findById(id).orElse(null);
        if (existingDepartement != null) {
            existingDepartement.setNom(departement.getNom());
            departementRepository.save(existingDepartement);
        }
        return existingDepartement;
    }

}
