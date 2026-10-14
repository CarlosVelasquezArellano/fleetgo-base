package com.nttdata.ms_reservas.servicio;

import com.nttdata.ms_reservas.cliente.VehiculoClient;
import com.nttdata.ms_reservas.model.Reserva;
import com.nttdata.ms_reservas.model.ReservaRequest;
import com.nttdata.ms_reservas.model.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

/** Reglas de negocio de las reservas. */
@Service
public class ReservaService {

    private final static int DIAS_MINIMOS = 1;
    private final static int DIAS_MAXIMOS = 30;
    private final static int DIAS_PARA_DESCUENTO = 7;
    private final static double DESCUENTO = 0.10;

    // TODO 14: declara las dependencias e inyéctalas por constructor.
    //          IMPORTANTE: depende de la interfaz VehiculoClient, nunca de RestClient
    //          ni de VehiculoClientRest (desacoplamiento).

    private final VehiculoClient vehiculoClient;
    private final ReservaRepository repository;

    public ReservaService(VehiculoClient vehiculoClient, ReservaRepository repository) {
        this.vehiculoClient = vehiculoClient;
        this.repository = repository;
    }

    // TODO 15: implementa el flujo de creación de la reserva:
    //   1. valida los datos (RN-01)
    //   2. busca el vehículo con vehiculoClient.buscar(...)
    //   3. si no está disponible -> VehiculoNoDisponibleException("VEHICULO NO DISPONIBLE")  (RN-04)
    //   4. si ya tiene una reserva -> VehiculoNoDisponibleException("YA RESERVADO")          (RN-05)
    //   5. calcula el total y guarda la reserva con estado "CONFIRMADA"
    public Reserva crear(ReservaRequest req) {
        validar(req);

        Vehiculo vehiculo = vehiculoClient.buscar(req.vehiculoId());

        if (!vehiculo.disponible()) {
            throw new VehiculoNoDisponibleException("VEHICULO NO DISPONIBLE");
        }

        if (repository.tieneReservaActiva(vehiculo.id())) {
            throw new VehiculoNoDisponibleException("YA RESERVADO");
        }

        var reserva = new Reserva(
                null, // se crea por defecto al guardar
                vehiculo.id(),
                vehiculo.placa(),
                req.cliente(),
                req.dias(),
                calcularTotal(vehiculo.tarifaDia(), req.dias()),
                "CONFIRMADA"
        );

        return repository.guardar(reserva);

    }

    // TODO 16: devuelve todas las reservas registradas.
    public List<Reserva> listar() {
        return repository.listar();
    }

    // TODO 17 (RN-02 y RN-03): total = tarifa diaria x días;
    //          si son 7 días o más se aplica un 10% de descuento. Usa constantes.
    private double calcularTotal(double tarifaDia, int dias) {
        double total = tarifaDia * dias;
        return dias >= DIAS_PARA_DESCUENTO ? total * (1 - DESCUENTO) : total;
    }

    // TODO 18 (RN-01): cliente obligatorio y días entre 1 y 30; si no, IllegalArgumentException.
    private void validar(ReservaRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("La solicitud es obligatoria");
        }
        if (req.cliente() == null || req.cliente().isBlank()) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (req.dias() < DIAS_MINIMOS || req.dias() > DIAS_MAXIMOS) {
            throw new IllegalArgumentException("Los días deben estar entre 1 y 30");
        }
    }
}
