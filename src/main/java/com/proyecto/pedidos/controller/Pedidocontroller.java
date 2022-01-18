package com.proyecto.pedidos.controller;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.pedidos.DTO.ClienteDTO;
import com.proyecto.pedidos.entity.Cliente;
import com.proyecto.pedidos.entity.Producto;

import com.proyecto.pedidos.services.ClienteService;
import com.proyecto.pedidos.services.ProductoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Pedidocontroller {
    //////////////////////////////////////////////////////----CLIENTE----//////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private ClienteService clienteService;

    // Crear CLiente
    @PostMapping("cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente newCliente) {
        return clienteService.crearCliente(newCliente);
    }

    // Borrar Cliente
    @DeleteMapping("cliente/eliminar")
    public void deleteById(@RequestParam(required = false) Long id) {
        clienteService.deleteById(id);
    }
    
    //Actualizar cliente
    @PutMapping("cliente/actualizar")
    public Cliente actCliente(@RequestBody Cliente newCliente, @RequestParam(required = false) Long id) {
        try {
              return clienteService.actCliente(newCliente, id);
              
            } catch (Exception e) {
                e.printStackTrace();
            }
        return newCliente;
    }

    // Consultar cliente por ID
    @GetMapping("cliente/consulta/{id}")
    public Cliente getClienteId(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    // Listar todos los clientes
    @GetMapping("cliente")
    public ResponseEntity<List<ClienteDTO>> list() {
        List<Cliente> list = clienteService.list();
        ModelMapper model = new ModelMapper();

        List<ClienteDTO> result = new ArrayList<>();

        for (Cliente cliente : list) {

            ClienteDTO clientedto = model.map(cliente, ClienteDTO.class);
            result.add(clientedto);

        }
        return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.OK);
    }

    // Buscar Cliente por nombre con producto
    @GetMapping("cliente/nombre")
    public ResponseEntity<List<ClienteDTO>> findClienteByNombre(@RequestParam(required = false) String nombre) {
        List<Cliente> list = clienteService.findClienteByNombre(nombre);
        ModelMapper model = new ModelMapper();

        List<ClienteDTO> result = new ArrayList<>();

        for (Cliente cliente : list) {

            ClienteDTO clientedto = model.map(cliente, ClienteDTO.class);
            result.add(clientedto);

        }
        return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.OK);
    }

    // Buscar cliente por Id con producto
    @GetMapping("cliente/id")
    public ResponseEntity<List<ClienteDTO>> findClienteById(@RequestParam(required = false) Long id) {
        List<Cliente> list = clienteService.findClienteById(id);
        ModelMapper model1 = new ModelMapper();

        List<ClienteDTO> result = new ArrayList<>();

        for (Cliente cliente1 : list) {

            ClienteDTO clientedto = model1.map(cliente1, ClienteDTO.class);
            result.add(clientedto);

        }
        return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.OK);
    }

    //////////////////////////////////////////////////////----PRODUCTO----//////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private ProductoService productoService;

    // Crear Producto
    @PostMapping("producto/crear")
    public Producto crearProducto(@RequestBody Producto newProducto) {
        return productoService.crearProducto(newProducto);
    }

    // Listar todos los productos
    @GetMapping("producto/consulta/{page}/{size}")
    Page<Producto> getProducto(@PathVariable int page,
            @PathVariable int size) {
        return productoService.getProducto(PageRequest.of(page, size));
    }

    // Consultar producto por ID
    @GetMapping("producto/consulta/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    // Actualizar producto
    @PutMapping("producto/actualizar")
    public Producto actProducto(@RequestBody Producto newProducto, @RequestParam Long id) {
        try {
            return productoService.actProducto(newProducto, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newProducto;

    }
}
