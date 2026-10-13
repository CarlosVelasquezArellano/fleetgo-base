package com.nttdata.ms_reservas.cliente;

import com.nttdata.ms_reservas.model.Vehiculo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

/** Implementación REST del contrato: aquí vive el detalle HTTP y la traducción de errores. */
@Component
public class VehiculoClientRest implements VehiculoClient {

    // TODO 9: inyecta el RestClient por constructor.
    public VehiculoClientRest(RestClient restClient) {
    }

    // TODO 10: llama a GET /api/vehiculos/{id} y devuelve el Vehiculo.
    //          Traduce los errores: 404 -> VehiculoNoEncontradoException (RN-06)
    //                               sin conexión -> CatalogoNoDisponibleException (RN-07)
    @Override
    public Vehiculo buscar(Long id) {
        throw new UnsupportedOperationException("TODO 10");
    }
}
