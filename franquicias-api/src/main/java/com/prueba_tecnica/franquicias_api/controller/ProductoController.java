package com.prueba_tecnica.franquicias_api.controller;

import com.prueba_tecnica.franquicias_api.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/producto")
public interface ProductoController {

    @PostMapping("/guardar/")
    Producto guardarProducto(@RequestBody Producto producto);

    @GetMapping("/listar/{nombre}")
    ResponseEntity<Producto> consultarProductoPorNombre(@PathVariable("nombre") String nombre);

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarProducto(@PathVariable("id") Long id);
}
