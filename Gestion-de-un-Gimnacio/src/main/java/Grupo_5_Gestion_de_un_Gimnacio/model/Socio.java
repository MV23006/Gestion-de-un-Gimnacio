package Grupo_5_Gestion_de_un_Gimnacio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
}