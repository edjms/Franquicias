package com.prueba_tecnica.franquicias_api.controller.impl;

import com.prueba_tecnica.franquicias_api.controller.SucursalController;
import com.prueba_tecnica.franquicias_api.model.Sucursal;
import com.prueba_tecnica.franquicias_api.service.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Service
public class SucursalControllerImpl implements SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Override
    public Sucursal guardarSucursal(Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

    @Override
    public ResponseEntity<Sucursal> consultarSucursalPorNombre(String nombre) {
        return sucursalService.consultarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
