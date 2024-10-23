package com.prueba_tecnica.franquicias_api.repository;

import com.prueba_tecnica.franquicias_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long> {
}
