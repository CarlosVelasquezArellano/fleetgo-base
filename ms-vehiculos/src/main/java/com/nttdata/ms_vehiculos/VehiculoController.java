package com.nttdata.ms_vehiculos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * API REST del catálogo de vehículos.
 */
// TODO 1: anota la clase como @RestController y con la ruta base @RequestMapping("/api/vehiculos").
public class VehiculoController {

    // TODO 2: crea la lista de los 3 vehículos del enunciado (sección 5.2), en ese orden.
    private final List<Vehiculo> vehiculos = List.of();

    // TODO 3: anota el método con @GetMapping y devuelve la lista completa.
    public List<Vehiculo> listar() {
        throw new UnsupportedOperationException("TODO 3");
    }

    // TODO 4: anota con @GetMapping("/{id}") y recibe @PathVariable("id").
    //         Devuelve 200 con el vehículo, o 404 si no existe.
    public ResponseEntity<Vehiculo> obtener(Long id) {
        throw new UnsupportedOperationException("TODO 4");
    }
}
