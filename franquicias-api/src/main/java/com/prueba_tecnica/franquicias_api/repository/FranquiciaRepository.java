package com.prueba_tecnica.franquicias_api.repository;

import com.prueba_tecnica.franquicias_api.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository <Franquicia,Long> {
}
