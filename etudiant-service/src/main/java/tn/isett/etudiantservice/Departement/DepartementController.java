package tn.isett.etudiantservice.Departement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {
    private final DepartementService departementService;
    private final DepartementMapper departementMapper;

    public DepartementController(DepartementService departementService, DepartementMapper departementMapper) {
        this.departementService = departementService;
        this.departementMapper = departementMapper;
    }

    @PostMapping
    public ResponseEntity<DepartementDTO> saveDepartement(@RequestBody DepartementDTO departementDTO) {
        Departement entity = departementMapper.toEntity(departementDTO);
        return ResponseEntity.ok(departementMapper.toDTO(departementService.saveDepartement(entity)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartementDTO> getDepartementById(@PathVariable Long id) {
        Departement departement = departementService.getDepartementById(id);
        return departement != null ? ResponseEntity.ok(departementMapper.toDTO(departement)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DepartementDTO>> getAllDepartement() {
        List<DepartementDTO> dtos = departementService.getAllDepartement().stream()
                .map(departementMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartementDTO> updateDepartement(@PathVariable Long id, @RequestBody DepartementDTO departementDTO) {
        Departement entity = departementMapper.toEntity(departementDTO);
        Departement departementModif = departementService.updateDepartement(id, entity);
        return departementModif != null ? ResponseEntity.ok(departementMapper.toDTO(departementModif)) : ResponseEntity.notFound().build();
    }
}
