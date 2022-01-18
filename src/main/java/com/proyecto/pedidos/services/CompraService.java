package com.proyecto.pedidos.services;

import java.util.List;

import com.proyecto.pedidos.entity.Compra;

public interface CompraService {

    List<Compra> list2();
    List<Compra> findCompraById(Long id);
    Compra crearCompra(Compra newCompra);
    Compra actCompra(Compra newCompra, Long id);
}
