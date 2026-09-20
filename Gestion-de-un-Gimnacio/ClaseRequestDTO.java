package Grupo_5_Gestion_de_un_Gimnacio.dto;

import lombok.Data;

@Data
public class ClaseRequestDTO {
    private String nombre;
    private String horario;
    private Integer cupoMaximo;
    private Long entrenadorId;
}