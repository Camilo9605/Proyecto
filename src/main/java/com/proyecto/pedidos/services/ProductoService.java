package com.proyecto.pedidos.services;

import com.proyecto.pedidos.entity.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {

    Producto crearProducto(Producto newProducto);

    Page<Producto> getProducto(Pageable page);

    Producto getProductoById(Long id);

    void save(Producto producto1);

    Producto actProducto(Producto newProducto, Long id);

}
