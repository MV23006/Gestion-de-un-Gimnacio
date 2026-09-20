package Grupo_5_Gestion_de_un_Gimnasio.service;

import Grupo_5_Gestion_de_un_Gimnasio.dto.InscripcionRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.InscripcionResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.model.Clase;
import Grupo_5_Gestion_de_un_Gimnasio.model.Inscripcion;
import Grupo_5_Gestion_de_un_Gimnasio.model.Socio;
import Grupo_5_Gestion_de_un_Gimnasio.repository.ClaseRepository;
import Grupo_5_Gestion_de_un_Gimnasio.repository.InscripcionRepository;
import Grupo_5_Gestion_de_un_Gimnasio.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final SocioRepository socioRepository;
    private final ClaseRepository claseRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository,
                              SocioRepository socioRepository,
                              ClaseRepository claseRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.socioRepository = socioRepository;
        this.claseRepository = claseRepository;
    }

    public List<InscripcionResponseDTO> obtenerTodas() {
        return inscripcionRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // REGISTRAR INSCRIPCIÓN CON VALIDACIÓN DE CUPO MÁXIMO
    public InscripcionResponseDTO inscribirSocio(InscripcionRequestDTO dto) {
        Clase clase = claseRepository.findById(dto.getClaseId())
                .orElseThrow(() -> new RuntimeException("La clase no existe"));

        Socio socio = socioRepository.findById(dto.getSocioId())
                .orElseThrow(() -> new RuntimeException("El socio no existe"));

        // Validación de cupo máximo
        long inscritosActuales = inscripcionRepository.countByClaseId(clase.getId());
        if (inscritosActuales >= clase.getCupoMaximo()) {
            throw new RuntimeException("No se puede inscribir: Se ha alcanzado el cupo máximo de la clase (" + clase.getCupoMaximo() + ")");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setSocio(socio);
        inscripcion.setClase(clase);
        inscripcion.setFechaInscripcion(LocalDateTime.now());
        inscripcion.setAsistio(false);

        Inscripcion guardada = inscripcionRepository.save(inscripcion);
        return convertirAResponseDTO(guardada);
    }

    // MARCAR ASISTENCIA
    public InscripcionResponseDTO registrarAsistencia(Long id, Boolean asistio) {
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
        inscripcion.setAsistio(asistio);
        return convertirAResponseDTO(inscripcionRepository.save(inscripcion));
    }

    // CANCELAR INSCRIPCIÓN
    public void cancelarInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    private InscripcionResponseDTO convertirAResponseDTO(Inscripcion i) {
        InscripcionResponseDTO dto = new InscripcionResponseDTO();
        dto.setId(i.getId());
        if (i.getSocio() != null) {
            dto.setNombreSocio(i.getSocio().getNombre());
        }
        if (i.getClase() != null) {
            dto.setNombreClase(i.getClase().getNombre());
        }
        dto.setFechaInscripcion(i.getFechaInscripcion());
        dto.setAsistio(i.getAsistio());
        return dto;
    }
}
