package com.prueba_tecnica.franquicias_api.service;

import com.prueba_tecnica.franquicias_api.model.Sucursal;

import java.util.Optional;

public interface SucursalService {

    Sucursal crearSucursal (Sucursal sucursal);
    Optional<Sucursal> consultarPorNombre (String nombre);

}
