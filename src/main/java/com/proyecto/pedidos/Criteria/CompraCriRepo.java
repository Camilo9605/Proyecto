package com.proyecto.pedidos.Criteria;

import java.util.List;

import com.proyecto.pedidos.entity.Compra;

import org.springframework.stereotype.Repository;

@Repository
public interface CompraCriRepo {

    List<Compra> findCompraById(Long id);

}
