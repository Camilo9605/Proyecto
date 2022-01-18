package com.proyecto.pedidos.services;

import java.util.List;

import com.proyecto.pedidos.Criteria.CriteriaRepository;
import com.proyecto.pedidos.entity.Cliente;
import com.proyecto.pedidos.entity.Compra;
import com.proyecto.pedidos.entity.Factura;
import com.proyecto.pedidos.entity.Producto;

import com.proyecto.pedidos.repository.ClienteRepositoryCustom;
import com.proyecto.pedidos.repository.CompraRepository;
import com.proyecto.pedidos.repository.ProductoRepository;
import com.proyecto.pedidos.repository.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GeneralService implements ClienteService, ProductoService, FacturaService, CompraService {

    @Autowired
    CriteriaRepository criteriaQuery;

    ////////////////////////////// CLIENTE////////////////////////////////////////////////////////////////
    @Override
    public List<Cliente> findClienteByNombre(String nombre) {
        // TODO Auto-generated method stub
        return criteriaQuery.findClienteByNombre(nombre);
    }

    @Override
    public Cliente crearCliente(Cliente newCliente) {
        // TODO Auto-generated method stub
        return clienteRepositoryCustom.save(newCliente);
    }

    @Autowired
    private ClienteRepositoryCustom clienteRepositoryCustom;

    @Override
    public List<Cliente> list() {
        // TODO Auto-generated method stub
        return clienteRepositoryCustom.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        // TODO Auto-generated method stub
        clienteRepositoryCustom.save(cliente);
    }

    @Override
    public Cliente getClienteById(Long id) {

        return clienteRepositoryCustom.getClienteById(id);
    }

    @Override
    public List<Cliente> findClienteById(Long id) {
        // TODO Auto-generated method stub
        return criteriaQuery.findClienteById(id);
    }
    //Actualizar cliente por ID


    ////////////////////////////////////////// PRODUCTO////////////////////////////////////////////////////////
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto newProducto) {
        return productoRepository.save(newProducto);
    }

    @Override
    public Page<Producto> getProducto(Pageable page) {

        return productoRepository.findAll(page);
    }

    @Override
    public Producto getProductoById(Long id) {

        return productoRepository.getProductoById(id);
    }

    @Override
    public void save(Producto producto) {
        // TODO Auto-generated method stub
        productoRepository.save(producto);

    }


    /////////////////////////////////////////////////////// FACTURA///////////////////////////////////////////////////
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> lists() {
        // TODO Auto-generated method stub
        return facturaRepository.findAll();
    }

    @Override
    public void save(Factura factura1) {
        return;

    }

    @Override
    public List<Factura> list3() {
        // TODO Auto-generated method stub
        return facturaRepository.findAll();
    }

    /////////////////////////////////////////////////////////////// COMPRA////////////////////////////////////////////////////////////////////
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> list2() {
        // TODO Auto-generated method stub
        return compraRepository.findAll();
    }

    @Override
    public List<Compra> findCompraById(Long id) {

        return criteriaQuery.findCompraById(id);
    }

    @Override
    public List<Factura> findFacturaById(Long id) {
        // TODO Auto-generated method stub
        return criteriaQuery.findFacturaById(id);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
          clienteRepositoryCustom.deleteById(id);

        
    }

    @Override
    public Compra crearCompra(Compra newCompra) {
        // TODO Auto-generated method stub
        return compraRepository.save(newCompra);
    }

    @Override
    public Producto actProducto(Producto newProducto, Long id) {
        // TODO Auto-generated method stub
        return productoRepository.save(newProducto);
    }

    @Override
    public Cliente actCliente(Cliente newCliente, Long id) {
        // TODO Auto-generated method stub
        return clienteRepositoryCustom.save(newCliente);
    }

    @Override
    public Compra actCompra(Compra newCompra, Long id) {
        // TODO Auto-generated method stub
        return compraRepository.save(newCompra);
    }
}

/* */