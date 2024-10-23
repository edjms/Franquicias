package com.prueba_tecnica.franquicias_api.controller;

import com.prueba_tecnica.franquicias_api.model.Franquicia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/franquicia")
public interface FranquiciaController {

    @PostMapping("/guardar/")
    Franquicia guardarFranquicia(@RequestBody Franquicia franquicia);

    @GetMapping("/listar/{nombre}")
    ResponseEntity<Franquicia> extraerFranquiciaPorNombre (@PathVariable("nombre") String nombre);

}
