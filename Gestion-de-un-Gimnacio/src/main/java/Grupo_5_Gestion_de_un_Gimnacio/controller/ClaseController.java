package Grupo_5_Gestion_de_un_Gimnacio.controller;

import Grupo_5_Gestion_de_un_Gimnacio.dto.ClaseRequestDTO;
import Grupo_5_Gestion_de_un_Gimnacio.dto.ClaseResponseDTO;
import Grupo_5_Gestion_de_un_Gimnacio.service.ClaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public List<ClaseResponseDTO> listar() {
        return claseService.obtenerTodas();
    }

    @PostMapping
    public ClaseResponseDTO crear(@RequestBody ClaseRequestDTO dto) {
        return claseService.guardar(dto);
    }

    @PutMapping("/{id}")
    public ClaseResponseDTO actualizar(@PathVariable Long id, @RequestBody ClaseRequestDTO dto) {
        return claseService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        claseService.eliminar(id);
    }
}