package com.nttdata.ms_reservas.servicio;

import com.nttdata.ms_reservas.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/** Almacén en memoria de las reservas. */
@Repository
public class ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong();

    // TODO 11: guarda la reserva asignándole un id correlativo (1, 2, 3...) con la secuencia
    //          y devuélvela ya con su id.
    public Reserva guardar(Reserva reserva) {
        throw new UnsupportedOperationException("TODO 11");
    }

    // TODO 12 (RN-05): indica si el vehículo ya tiene una reserva registrada.
    public boolean tieneReservaActiva(Long vehiculoId) {
        throw new UnsupportedOperationException("TODO 12");
    }

    // TODO 13: devuelve la lista de reservas como vista de solo lectura.
    public List<Reserva> listar() {
        throw new UnsupportedOperationException("TODO 13");
    }
}
