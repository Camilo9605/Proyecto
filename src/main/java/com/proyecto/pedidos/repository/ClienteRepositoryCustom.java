package com.proyecto.pedidos.repository;

import java.util.List;

import com.proyecto.pedidos.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepositoryCustom extends JpaRepository <Cliente , Long> {


    List<Cliente> findAll();
    Cliente getClienteById(Long id);
    
    
    
    
    
}
