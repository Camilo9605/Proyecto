package com.proyecto.pedidos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.proyecto.pedidos.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT prod FROM Producto prod")
    Page<Producto> getByNombre(Pageable page);

    // Consultas
    List<Producto> findByCantidad(int cantidad);
    Producto getProductoById(Long id);
    List<Producto> findByNombreAndCantidad(String nombre, int cantidad);

}
