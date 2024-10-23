package com.prueba_tecnica.franquicias_api.repository;

import com.prueba_tecnica.franquicias_api.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia,Long> {

    Optional<Franquicia> findByNombre(String nombre);
}
