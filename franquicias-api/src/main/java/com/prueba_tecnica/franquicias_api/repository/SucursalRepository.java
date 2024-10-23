package com.prueba_tecnica.franquicias_api.repository;

import com.prueba_tecnica.franquicias_api.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository <Sucursal,Long> {
}
