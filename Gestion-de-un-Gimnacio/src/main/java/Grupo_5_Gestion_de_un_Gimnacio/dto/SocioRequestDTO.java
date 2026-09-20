package Grupo_5_Gestion_de_un_Gimnacio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SocioRequestDTO {
    private String nombre;
    private String email;
    private String telefono;

    public SocioRequestDTO() {}

    public SocioRequestDTO(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

}