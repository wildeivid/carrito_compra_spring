package com.carritocompra.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carritocompra.app.models.entity.Producto;

@Repository
public class ProductoDAO implements IProductoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> listaProductos() {
		return this.entityManager.createQuery("from Producto").getResultList();
	}

	@Override
	public void guardarProducto(Producto producto) {
		if (producto.getId() != null && producto.getId() > 0) {
			this.entityManager.merge(producto);
		} else {
			this.entityManager.persist(producto);
		}
	}

	@Override
	public void editarProducto(Producto producto) {
		if (producto.getId() != null && producto.getId() > 0) {
			this.entityManager.merge(producto);
		} else {
			this.entityManager.persist(producto);
		}
	}

	@Override
	public void eliminarProducto(Long id) {
		this.entityManager.remove(this.buscarProductoPorId(id));
	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public Producto buscarProducto(Producto producto) {
		return this.entityManager.find(Producto.class, producto.getId());
	}

}
