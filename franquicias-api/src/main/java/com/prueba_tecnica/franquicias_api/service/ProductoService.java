package com.prueba_tecnica.franquicias_api.service;

import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.model.Sucursal;

import java.util.Optional;

public interface ProductoService {

    Producto crearProducto (Producto producto);
    Optional<Producto> consultarPorNombre (String nombre);
    void EliminarProducto(Long id);
}
