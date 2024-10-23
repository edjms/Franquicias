package com.prueba_tecnica.franquicias_api.service;

import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.model.Sucursal;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Producto crearProducto (Producto producto);
    List<Producto> consultarPorNombre (String nombre);
    Producto actualizarStockProducto (Producto producto);
    void EliminarProducto(Long id);
    List<Producto> findTopStockByFranquiciaId(Long id);

}
