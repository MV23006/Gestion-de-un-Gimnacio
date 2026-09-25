package Grupo_5_Gestion_de_un_Gimnasio.controller;

import Grupo_5_Gestion_de_un_Gimnasio.model.Pago;
import Grupo_5_Gestion_de_un_Gimnasio.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.obtenerTodos();
    }

    @GetMapping("/socio/{socioId}")
    public List<Pago> listarPorSocio(@PathVariable Long socioId) {
        return pagoService.obtenerPorSocio(socioId);
    }

    @PostMapping
    public Pago registrarPago(@RequestBody Pago pago) {
        return pagoService.registrarPago(pago);
    }
}
