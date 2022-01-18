package com.proyecto.pedidos.Criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.proyecto.pedidos.entity.Cliente;
import com.proyecto.pedidos.entity.Compra;
import com.proyecto.pedidos.entity.Factura;
import com.proyecto.pedidos.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CriteriaRepository implements ClienteRepository, CompraCriRepo, FacturaCriRepo{
    
    @Autowired
    EntityManager em;
    
    @Override
    public List <Cliente> findClienteByNombre(String nombre){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> clientes = cq.from(Cliente.class);
        
        Predicate predicateNombre = cb.equal(clientes.get("nombre"), nombre);
        cq.where(predicateNombre);

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List <Cliente> findClienteById(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> clientes = cq.from(Cliente.class);
        
        Predicate predicateNombre = cb.equal(clientes.get("id"), id);
        cq.where(predicateNombre);

        return em.createQuery(cq).getResultList();
    }
///////////////////////////////////////////////////////////COMPRA/////////////////////////////////////////////////////////
    @Override
    public List <Compra> findCompraById(Long id){
        CriteriaBuilder cbc = em.getCriteriaBuilder();
        CriteriaQuery<Compra> cqc = cbc.createQuery(Compra.class);
        Root<Compra> compras = cqc.from(Compra.class);
        
        Predicate predicateNombre = cbc.equal(compras.get("id"), id);
        cqc.where(predicateNombre);

        return em.createQuery(cqc).getResultList();
    }


    @Override
    public List<Factura> findFacturaById(Long id){
        CriteriaBuilder cbf = em.getCriteriaBuilder();
        CriteriaQuery<Factura> cqf = cbf.createQuery(Factura.class);
        Root<Factura> factura = cqf.from(Factura.class);
        
        Predicate predicateId = cbf.equal(factura.get("id"), id);
        cqf.where(predicateId);

        return em.createQuery(cqf).getResultList();
    }

}