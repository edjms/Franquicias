package com.prueba_tecnica.franquicias_api.repository;

import com.prueba_tecnica.franquicias_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long> {

    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.sucursal.franquicia.id = :franquiciaId ORDER BY p.stock DESC")
    List<Producto> findTopStockByFranquiciaId(Long franquiciaId);
}
