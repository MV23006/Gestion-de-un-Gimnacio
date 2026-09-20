package Grupo_5_Gestion_de_un_Gimnasio.controller;

import Grupo_5_Gestion_de_un_Gimnasio.dto.EntrenadorRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.EntrenadorResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<EntrenadorResponseDTO> listar() {
        return entrenadorService.obtenerTodos();
    }

    @PostMapping
    public EntrenadorResponseDTO crear(@RequestBody EntrenadorRequestDTO dto) {
        return entrenadorService.guardar(dto);
    }

    @PutMapping("/{id}")
    public EntrenadorResponseDTO actualizar(@PathVariable Long id, @RequestBody EntrenadorRequestDTO dto) {
        return entrenadorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        entrenadorService.eliminar(id);
    }
}