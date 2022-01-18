package com.proyecto.pedidos.controller;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.pedidos.DTO.FacturaDTO;
import com.proyecto.pedidos.entity.Factura;
import com.proyecto.pedidos.services.FacturaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Facturacontroller {

   @Autowired
   private FacturaService facturaService;

    @GetMapping("Factura")
    public ResponseEntity<List<FacturaDTO>> findFacturaById(Long id){
        List<Factura> list = facturaService.findFacturaById(id);
        ModelMapper modelt= new ModelMapper();

      List <FacturaDTO> result = new ArrayList<>();

    for(Factura todo : list){
        FacturaDTO facturaDTO = modelt.map(todo, FacturaDTO.class);
        result.add(facturaDTO);
    }
    return new ResponseEntity<List<FacturaDTO>>(result,HttpStatus.OK);
 }


    
}
