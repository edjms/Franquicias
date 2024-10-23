package com.prueba_tecnica.franquicias_api.controller.impl;

import com.prueba_tecnica.franquicias_api.controller.FranquiciaController;
import com.prueba_tecnica.franquicias_api.model.Franquicia;
import com.prueba_tecnica.franquicias_api.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class FranquiciaControllerImpl implements FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @Override
    public Franquicia guardarFranquicia(Franquicia franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    @Override
    public ResponseEntity<Franquicia> extraerFranquiciaPorNombre(String nombre) {
        return franquiciaService.consultarFranquiciaPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
