package Grupo_5_Gestion_de_un_Gimnasio.service;

import Grupo_5_Gestion_de_un_Gimnasio.model.Pago;
import Grupo_5_Gestion_de_un_Gimnasio.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public List<Pago> obtenerPorSocio(Long socioId) {
        return pagoRepository.findBySocioId(socioId);
    }

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}