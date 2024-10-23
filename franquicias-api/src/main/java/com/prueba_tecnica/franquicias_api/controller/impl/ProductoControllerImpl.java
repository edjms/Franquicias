package com.prueba_tecnica.franquicias_api.controller.impl;

import com.prueba_tecnica.franquicias_api.controller.ProductoController;
import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ProductoControllerImpl implements ProductoController {

    @Autowired
    private ProductoService productoService;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoService.crearProducto(producto);
    }

    @Override
    public ResponseEntity<Producto> consultarProductoPorNombre(String nombre) {
        return productoService.consultarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Producto> actualizarStockProducto(Producto producto) {
        Producto productoActualizado = productoService.actualizarStockProducto(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @Override
    public ResponseEntity<String> eliminarProducto(Long id) {
        productoService.EliminarProducto(id);
        return new ResponseEntity<>("200 ok", HttpStatus.OK);
    }
}
