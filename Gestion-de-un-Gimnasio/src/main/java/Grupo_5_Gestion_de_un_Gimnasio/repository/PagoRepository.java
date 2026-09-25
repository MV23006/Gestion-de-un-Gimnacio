package Grupo_5_Gestion_de_un_Gimnasio.repository;

import Grupo_5_Gestion_de_un_Gimnasio.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findBySocioId(Long socioId);
}