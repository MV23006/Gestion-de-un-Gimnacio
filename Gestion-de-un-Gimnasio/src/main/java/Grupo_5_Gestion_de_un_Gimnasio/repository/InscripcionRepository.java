package Grupo_5_Gestion_de_un_Gimnasio.repository;

import Grupo_5_Gestion_de_un_Gimnasio.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Cuenta cuántos socios están inscritos en una clase para controlar el cupo
    long countByClaseId(Long claseId);

    // Listar las inscripciones de una clase específica
    List<Inscripcion> findByClaseId(Long claseId);
}