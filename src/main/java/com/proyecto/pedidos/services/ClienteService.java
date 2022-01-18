package com.proyecto.pedidos.services;

import java.util.List;

import com.proyecto.pedidos.entity.Cliente;
import com.proyecto.pedidos.entity.Producto;

public interface ClienteService {
    
    Cliente crearCliente(Cliente newCliente);
    Cliente getClienteById(Long id);
    List <Cliente> findClienteByNombre(String nombre);
    List <Cliente> findClienteById(Long id);
    
    List<Cliente> list();
    void save(Producto producto);
    void save(Cliente cliente);
    void deleteById(Long id);
    Cliente actCliente(Cliente newCliente, Long id);
    
    
}
