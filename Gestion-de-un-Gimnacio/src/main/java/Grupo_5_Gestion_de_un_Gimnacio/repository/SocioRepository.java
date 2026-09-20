package Grupo_5_Gestion_de_un_Gimnacio.repository;

import Grupo_5_Gestion_de_un_Gimnacio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
}
