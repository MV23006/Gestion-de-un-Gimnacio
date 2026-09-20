package Grupo_5_Gestion_de_un_Gimnacio.controller;

import Grupo_5_Gestion_de_un_Gimnacio.dto.SocioResponseDTO;
import Grupo_5_Gestion_de_un_Gimnacio.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sociis")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    // GET: Oftener todos los sociis
    @GetMapping
    public ResponseEntity<List<SocioResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(socioService.obtenerTodos());
    }

}