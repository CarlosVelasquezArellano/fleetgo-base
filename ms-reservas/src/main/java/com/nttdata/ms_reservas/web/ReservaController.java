package com.nttdata.ms_reservas.web;

import com.nttdata.ms_reservas.cliente.CatalogoNoDisponibleException;
import com.nttdata.ms_reservas.cliente.VehiculoNoEncontradoException;
import com.nttdata.ms_reservas.model.Reserva;
import com.nttdata.ms_reservas.model.ReservaRequest;
import com.nttdata.ms_reservas.servicio.ReservaService;
import com.nttdata.ms_reservas.servicio.VehiculoNoDisponibleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** API REST de reservas. */
// TODO 19: anota la clase como @RestController con la ruta base @RequestMapping("/api/reservas")
//          e inyecta ReservaService por constructor.
public class ReservaController {

    public ReservaController(ReservaService service) {
    }

    // TODO 20: anota con @PostMapping y @RequestBody. Devuelve 201 con la reserva creada y,
    //          según la excepción, el estado correcto usando el método error(...):
    //            IllegalArgumentException          -> 400 "DATOS INVALIDOS"
    //            VehiculoNoDisponibleException     -> 409 con e.getMessage()
    //            VehiculoNoEncontradoException     -> 404 "VEHICULO NO EXISTE"
    //            CatalogoNoDisponibleException     -> 503 "CATALOGO NO DISPONIBLE"
    public ResponseEntity<Reserva> crear(ReservaRequest req) {
        throw new UnsupportedOperationException("TODO 20");
    }

    // TODO 21: anota con @GetMapping y devuelve la lista de reservas del servicio.
    public List<Reserva> listar() {
        throw new UnsupportedOperationException("TODO 21");
    }

    /** Construye la respuesta de error. (Resuelto) */
    private ResponseEntity<Reserva> error(ReservaRequest req, HttpStatus estado, String mensaje) {
        return ResponseEntity.status(estado)
                .body(new Reserva(null, req.vehiculoId(), null, req.cliente(), req.dias(), 0, mensaje));
    }
}
