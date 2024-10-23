package com.prueba_tecnica.franquicias_api.controller;

import com.prueba_tecnica.franquicias_api.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/producto")
public interface ProductoController {

    @PostMapping("/guardar/")
    Producto guardarProducto(@RequestBody Producto producto);

    @GetMapping("/listar/{nombre}")
    ResponseEntity<List<Producto>> consultarProductoPorNombre(@PathVariable("nombre") String nombre);

    @PostMapping("/actualizar/stock")
    ResponseEntity<Producto> actualizarStockProducto(@RequestBody Producto producto);

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarProducto(@PathVariable("id") Long id);

    @GetMapping("/stock/sucursal/{id}")
    ResponseEntity<List<Producto>> obtenerProductoMayorStock(@PathVariable("id") Long id);

}

