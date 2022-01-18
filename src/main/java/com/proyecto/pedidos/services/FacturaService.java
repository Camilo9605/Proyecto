package com.proyecto.pedidos.services;

import java.util.List;

import com.proyecto.pedidos.entity.Factura;

public interface FacturaService {

    List<Factura> lists();
    void save(Factura factura1);
    List<Factura> list3();
    List<Factura> findFacturaById(Long id);
    
}
