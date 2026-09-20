package Grupo_5_Gestion_de_un_Gimnasio.controller;

import Grupo_5_Gestion_de_un_Gimnasio.dto.ClaseRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.ClaseResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.service.ClaseService;
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