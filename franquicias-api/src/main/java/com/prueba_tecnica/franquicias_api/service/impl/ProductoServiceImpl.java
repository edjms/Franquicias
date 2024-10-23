package com.prueba_tecnica.franquicias_api.service.impl;

import com.prueba_tecnica.franquicias_api.model.Producto;
import com.prueba_tecnica.franquicias_api.model.Sucursal;
import com.prueba_tecnica.franquicias_api.repository.ProductoRepository;
import com.prueba_tecnica.franquicias_api.repository.SucursalRepository;
import com.prueba_tecnica.franquicias_api.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Producto> consultarPorNombre(String nombre) {
        List<Producto> producto = productoRepository.findByNombre(nombre);
        return producto;
    }

    @Override
    public Producto actualizarStockProducto(Producto producto) {
        List<Producto> ExistenciaProducto = productoRepository.findByNombre(producto.getNombre());
        if(!ExistenciaProducto.isEmpty()){
            throw new RuntimeException("No existe producto con nombre" + producto.getNombre());
        }
        Producto productoExistente = ExistenciaProducto.get(0);
        productoExistente.setStock(producto.getStock());
        return productoRepository.save(productoExistente);
    }

    @Override
    public void EliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findTopStockByFranquiciaId(Long id) {
        List<Producto> productos = productoRepository.findTopStockByFranquiciaId(id);
        return productos.isEmpty() ? List.of() : List.of(productos.get(0));
    }


}
