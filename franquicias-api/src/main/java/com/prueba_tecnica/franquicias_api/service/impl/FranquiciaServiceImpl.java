package com.prueba_tecnica.franquicias_api.service.impl;

import com.prueba_tecnica.franquicias_api.model.Franquicia;
import com.prueba_tecnica.franquicias_api.repository.FranquiciaRepository;
import com.prueba_tecnica.franquicias_api.service.FranquiciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    @Autowired
    private final FranquiciaRepository franquiciaRepository;

    @Override
    public Franquicia crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public Optional<Franquicia> consultarFranquiciaPorNombre(String nombre) {
        return franquiciaRepository.findByNombre(nombre);
    }

}
