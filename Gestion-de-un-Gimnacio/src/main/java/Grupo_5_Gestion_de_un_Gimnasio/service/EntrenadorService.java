package Grupo_5_Gestion_de_un_Gimnasio.service;

import Grupo_5_Gestion_de_un_Gimnasio.dto.EntrenadorRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.EntrenadorResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.model.Entrenador;
import Grupo_5_Gestion_de_un_Gimnasio.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<EntrenadorResponseDTO> obtenerTodos() {
        return entrenadorRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    public EntrenadorResponseDTO guardar(EntrenadorRequestDTO dto) {
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(dto.getNombre());
        entrenador.setEspecialidad(dto.getEspecialidad());
        Entrenador guardado = entrenadorRepository.save(entrenador);
        return convertirAResponseDTO(guardado);
    }

    public EntrenadorResponseDTO actualizar(Long id, EntrenadorRequestDTO dto) {
        Entrenador entrenador = entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        entrenador.setNombre(dto.getNombre());
        entrenador.setEspecialidad(dto.getEspecialidad());
        return convertirAResponseDTO(entrenadorRepository.save(entrenador));
    }

    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }

    private EntrenadorResponseDTO convertirAResponseDTO(Entrenador e) {
        EntrenadorResponseDTO dto = new EntrenadorResponseDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setEspecialidad(e.getEspecialidad());
        return dto;
    }
}