package com.proyecto.pedidos.DTO;

public class CompraDTO {

    private Long id;
    private ClienteDTO Cliente;
    private ProductoDTO Producto;

    public CompraDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        Cliente = cliente;
    }

    public ProductoDTO getProducto() {
        return Producto;
    }

    public void setProducto(ProductoDTO producto) {
        Producto = producto;
    }
    

}
