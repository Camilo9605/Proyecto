package com.proyecto.pedidos.Criteria;

import java.util.List;

import com.proyecto.pedidos.entity.Factura;

import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCriRepo {

    List<Factura> findFacturaById(Long id);
    
}
