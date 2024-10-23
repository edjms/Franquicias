package com.prueba_tecnica.franquicias_api.service;

import com.prueba_tecnica.franquicias_api.model.Franquicia;

import java.util.Optional;

public interface FranquiciaService {

    Franquicia crearFranquicia (Franquicia franquicia);
    Optional<Franquicia> consultarFranquiciaPorNombre (String nombre);

}
