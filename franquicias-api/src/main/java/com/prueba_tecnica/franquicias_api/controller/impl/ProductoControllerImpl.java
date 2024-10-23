package com.prueba_tecnica.franquicias_api.controller.impl;

import com.prueba_tecnica.franquicias_api.controller.ProductoController;
import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class ProductoControllerImpl implements ProductoController {

    @Autowired
    private ProductoService productoService;

    @Override
    public Producto guardarProducto(Producto producto) {
        List<Producto> productoExiste = productoService.consultarPorNombre(producto.getNombre());
        boolean existeEnSucursal = productoExiste.stream()
                .anyMatch(p -> p.getSucursal().getId().equals(producto.getSucursal().getId()));
        if (existeEnSucursal) {
            throw new RuntimeException("El producto " + producto.getNombre() + " ya existe en la sucursal " + producto.getSucursal().getId());
        } else {
            return productoService.crearProducto(producto);
        }
    }

    @Override
    public ResponseEntity<List<Producto>> consultarProductoPorNombre(String nombre) {
        List<Producto> productos = productoService.consultarPorNombre(nombre);
        if (productos != null && !productos.isEmpty()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @Override
    public ResponseEntity<List<Producto>> obtenerProductoMayorStock(@PathVariable Long id) {
        List<Producto> productos = productoService.findTopStockByFranquiciaId(id);
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productos);
    }

}
