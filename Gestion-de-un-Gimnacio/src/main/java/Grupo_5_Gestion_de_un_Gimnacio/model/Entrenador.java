package Grupo_5_Gestion_de_un_Gimnacio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrenadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especialidad; // Ej: Yoga, Funcional, Crossfit
}