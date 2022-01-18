package com.proyecto.pedidos.repository;

import java.util.List;

import com.proyecto.pedidos.entity.Cliente;

import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository  {


    List <Cliente> findClienteByNombre(String nombre);
    List <Cliente> findClienteById(Long id); 


   
}
