package tn.isett.etudiantservice.Departement;

import org.springframework.stereotype.Component;

@Component
public class DepartementMapper {

    public DepartementDTO toDTO(Departement departement) {
        DepartementDTO dto = new DepartementDTO();
        dto.setId(departement.getId());
        dto.setNom(departement.getNom());
        return dto;
    }

    public Departement toEntity(DepartementDTO dto) {
        Departement departement = new Departement();
        departement.setId(dto.getId());
        departement.setNom(dto.getNom());
        return departement;
    }
}