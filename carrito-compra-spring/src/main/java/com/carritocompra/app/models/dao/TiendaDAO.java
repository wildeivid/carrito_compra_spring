package com.carritocompra.app.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.ProductoCarrito;

@Repository
public class TiendaDAO implements ITiendaDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addProductoToCarrito(Carrito carrito, Producto producto) {
		ProductoCarrito productoCarrito = new ProductoCarrito();
		productoCarrito.setCarrito(carrito);
		productoCarrito.setProducto(producto);
		productoCarrito.setQuantity(1);
		
		this.entityManager.persist(productoCarrito);
		
	}

}
