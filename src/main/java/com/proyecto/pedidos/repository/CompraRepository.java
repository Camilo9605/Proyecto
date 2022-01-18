package com.proyecto.pedidos.repository;

import java.util.List;

import com.proyecto.pedidos.entity.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository <Compra, Long>{
    

    List<Compra> findAll();
}
