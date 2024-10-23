package com.prueba_tecnica.franquicias_api.service.impl;

import com.prueba_tecnica.franquicias_api.model.Franquicia;
import com.prueba_tecnica.franquicias_api.model.Sucursal;
import com.prueba_tecnica.franquicias_api.repository.FranquiciaRepository;
import com.prueba_tecnica.franquicias_api.repository.SucursalRepository;
import com.prueba_tecnica.franquicias_api.service.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private final FranquiciaRepository franquiciaRepository;
    @Autowired
    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
       Franquicia consultarFranquicia = franquiciaRepository.findByNombre(sucursal.getFranquicia().getNombre())
                .orElseThrow(() -> new RuntimeException("franquicia no encontrada"));
        sucursal.setFranquicia(consultarFranquicia);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Optional<Sucursal> consultarPorNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }
}
