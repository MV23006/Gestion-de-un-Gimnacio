package Grupo_5_Gestion_de_un_Gimnasio.dto;

import lombok.Data;

@Data
public class ClaseResponseDTO {
    private Long id;
    private String nombre;
    private String horario;
    private Integer cupoMaximo;
    private String nombreEntrenador;
}