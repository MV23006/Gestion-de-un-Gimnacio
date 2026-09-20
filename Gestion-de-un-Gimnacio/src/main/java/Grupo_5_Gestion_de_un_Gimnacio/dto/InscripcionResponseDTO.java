package Grupo_5_Gestion_de_un_Gimnacio.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InscripcionResponseDTO {
    private Long id;
    private String nombreSocio;
    private String nombreClase;
    private LocalDateTime fechaInscripcion;
    private Boolean asistio;
}