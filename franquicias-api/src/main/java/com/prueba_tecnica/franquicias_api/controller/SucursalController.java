package com.prueba_tecnica.franquicias_api.controller;

import com.prueba_tecnica.franquicias_api.model.Sucursal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/sucursal")
public interface SucursalController {

    @PostMapping("/guardar/")
    Sucursal guardarSucursal(@RequestBody Sucursal sucursal);

    @GetMapping("/listar/{nombre}")
    ResponseEntity<Sucursal> consultarSucursalPorNombre(@PathVariable("nombre") String nombre);

}
