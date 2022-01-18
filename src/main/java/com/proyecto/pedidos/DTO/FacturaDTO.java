package com.proyecto.pedidos.DTO;

public class FacturaDTO {

    private Long id;
    private Integer cantidad;
    private float total;

    private CompraDTO Compra;

    public FacturaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CompraDTO getCompra() {
        return Compra;
    }

    public void setCompra(CompraDTO compra) {
        Compra = compra;
    }

}
