package com.proyecto.pedidos.controller;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.pedidos.DTO.CompraDTO;
import com.proyecto.pedidos.entity.Compra;
import com.proyecto.pedidos.services.CompraService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Compracontroller {

    // Crear Compra
    @PostMapping("crear/compra")
    public Compra crearCompra(@RequestBody Compra newCompra) {

        return compraService.crearCompra(newCompra);
    }

    @Autowired
    private CompraService compraService;
    //Listar compras             
    @GetMapping("compra/lista")
    
    public ResponseEntity<List<CompraDTO>> findCompraById(@RequestParam(required = false) Long id) {
        List<Compra> list = compraService.findCompraById(id);
        ModelMapper modes = new ModelMapper();

        List<CompraDTO> res = new ArrayList<>();

        for (Compra clien : list) {
            CompraDTO compraDTO = modes.map(clien, CompraDTO.class);
            res.add(compraDTO);
        }
        return new ResponseEntity<List<CompraDTO>>(res, HttpStatus.OK);
    }
    
    @PutMapping ("compra/actualizar")
    public Compra actCompra (@RequestBody Compra newCompra, @RequestParam (required = false) Long id) {
        try {
            return compraService.actCompra(newCompra, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCompra;

    }

}
