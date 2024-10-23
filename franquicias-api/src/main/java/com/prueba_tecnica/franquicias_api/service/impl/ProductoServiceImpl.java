package com.prueba_tecnica.franquicias_api.service.impl;

import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.model.Sucursal;
import com.prueba_tecnica.franquicias_api.repository.ProductoRepository;
import com.prueba_tecnica.franquicias_api.repository.SucursalRepository;
import com.prueba_tecnica.franquicias_api.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private final SucursalRepository sucursalRepository;
    @Autowired
    private final ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
       Sucursal consultarSucursal = sucursalRepository.findByNombre(producto.getSucursal().getNombre())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        producto.setSucursal(consultarSucursal);
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> consultarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public void EliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
