package Grupo_5_Gestion_de_un_Gimnasio.controller;

import Grupo_5_Gestion_de_un_Gimnasio.dto.InscripcionRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.InscripcionResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.service.InscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public List<InscripcionResponseDTO> listar() {
        return inscripcionService.obtenerTodas();
    }

    @PostMapping
    public InscripcionResponseDTO inscribir(@RequestBody InscripcionRequestDTO dto) {
        return inscripcionService.inscribirSocio(dto);
    }

    @PutMapping("/{id}/asistencia")
    public InscripcionResponseDTO marcarAsistencia(@PathVariable Long id, @RequestParam Boolean asistio) {
        return inscripcionService.registrarAsistencia(id, asistio);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        inscripcionService.cancelarInscripcion(id);
    }
}
