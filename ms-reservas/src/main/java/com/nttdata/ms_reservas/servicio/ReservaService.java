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

    // TODO 14: declara las dependencias e inyéctalas por constructor.
    //          IMPORTANTE: depende de la interfaz VehiculoClient, nunca de RestClient
    //          ni de VehiculoClientRest (desacoplamiento).
    public ReservaService(VehiculoClient vehiculoClient, ReservaRepository repository) {
    }

    // TODO 15: implementa el flujo de creación de la reserva:
    //   1. valida los datos (RN-01)
    //   2. busca el vehículo con vehiculoClient.buscar(...)
    //   3. si no está disponible -> VehiculoNoDisponibleException("VEHICULO NO DISPONIBLE")  (RN-04)
    //   4. si ya tiene una reserva -> VehiculoNoDisponibleException("YA RESERVADO")          (RN-05)
    //   5. calcula el total y guarda la reserva con estado "CONFIRMADA"
    public Reserva crear(ReservaRequest req) {
        throw new UnsupportedOperationException("TODO 15");
    }

    // TODO 16: devuelve todas las reservas registradas.
    public List<Reserva> listar() {
        throw new UnsupportedOperationException("TODO 16");
    }

    // TODO 17 (RN-02 y RN-03): total = tarifa diaria x días;
    //          si son 7 días o más se aplica un 10% de descuento. Usa constantes.
    private double calcularTotal(double tarifaDia, int dias) {
        throw new UnsupportedOperationException("TODO 17");
    }

    // TODO 18 (RN-01): cliente obligatorio y días entre 1 y 30; si no, IllegalArgumentException.
    private void validar(ReservaRequest req) {
        throw new UnsupportedOperationException("TODO 18");
    }
}
