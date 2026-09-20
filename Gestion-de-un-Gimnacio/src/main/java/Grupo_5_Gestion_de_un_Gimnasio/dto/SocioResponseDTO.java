package Grupo_5_Gestion_de_un_Gimnasio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SocioResponseDTO {
    // Getters y Setters
    private Long id;
    private String nombre;
    private String email;
    private String telefono;

    // Constructor vac
    public SocioResponseDTO() {}

    // Constructor con parametrise
    public SocioResponseDTO(Long id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

}