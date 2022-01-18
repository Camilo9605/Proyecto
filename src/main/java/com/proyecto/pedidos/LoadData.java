package com.proyecto.pedidos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.proyecto.pedidos.entity.Cliente;
import com.proyecto.pedidos.entity.Producto;
import com.proyecto.pedidos.services.ClienteService;
import com.proyecto.pedidos.services.ProductoService;

@Configuration
class LoadData {

    @Bean
    CommandLineRunner initDatabase(ClienteService clienteService) {
        return args -> {

            System.out.println("Probando la capa de servicios");

            Cliente cliente = new Cliente();
            cliente.setNombre("Cristian");
            cliente.setIdentificacion(1024569570);
            clienteService.save(cliente);

            Cliente cliente2 = new Cliente();
            cliente2.setNombre("Cristal");
            cliente2.setIdentificacion(1024245789);
            clienteService.save(cliente2);
            Cliente cliente3 = new Cliente();
            cliente3 = new Cliente();
            cliente3.setNombre("Adriana");
            cliente3.setIdentificacion(1024147852);
            clienteService.save(cliente3);

        };
    }

    @Bean
    CommandLineRunner initdatabase2(ProductoService productoService) {

        return args -> {
            Producto producto = new Producto();

            producto.setNombre("Carne");
            producto.setCantidad(100);
            producto.setPrecio((float) 5000);
            productoService.save(producto);

            Producto producto2 = new Producto();

            producto2.setNombre("Pollo");
            producto2.setCantidad(150);
            producto2.setPrecio((float) 4500);
            productoService.save(producto2);

            Producto producto3 = new Producto();

            producto3.setNombre("Papa");
            producto3.setCantidad(1000);
            producto3.setPrecio((float) 1000);

            productoService.save(producto3);

        };

    }

}
