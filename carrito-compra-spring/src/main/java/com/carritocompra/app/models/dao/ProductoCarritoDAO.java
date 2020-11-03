package com.carritocompra.app.models.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carritocompra.app.models.entity.Carrito;
import com.carritocompra.app.models.entity.Producto;
import com.carritocompra.app.models.entity.ProductoCarrito;
import com.carritocompra.app.models.entity.ProductoFinal;
import com.carritocompra.app.models.service.IProductoService;

@Repository
public class ProductoCarritoDAO implements IProductoCarritoDAO {
	
	private final StringBuilder SQL_CONSULTA_EXISTE_PRODUCTO_INTO_CARRITO = new StringBuilder("SELECT * FROM product_cars WHERE carrito_id = :carrito_id and producto_id = :producto_id");
	
	private final StringBuilder SQL_CONSULTA_CANTIDAD_PRODUCTO_INTO_CARRITO = new StringBuilder("SELECT * FROM product_cars p WHERE p.carrito_id = :carrito_id");
	
	private final StringBuilder SQL_CONSULTA_PRODUCTOS_POR_CARRITO = new StringBuilder("SELECT * FROM product_cars p WHERE p.carrito_id = :carrito_id");
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IProductoService iProductoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoCarritoDAO.class);
	
	@Override
	public ProductoCarrito isExisteProductoIntoCarrito(Carrito carrito, Producto producto) {
		ProductoCarrito productoCarrito = null;
		
		
		Query query = this.entityManager.createNativeQuery(SQL_CONSULTA_EXISTE_PRODUCTO_INTO_CARRITO.toString(), ProductoCarrito.class);
		query.setParameter("carrito_id", carrito.getId());
		query.setParameter("producto_id", producto.getId());
		
		try {
			productoCarrito = (ProductoCarrito) query.getSingleResult();
		}catch (NoResultException e) {
			productoCarrito = new ProductoCarrito();
			LOGGER.info("En el carrito - No existe el producto con codigo ".concat(producto.getId().toString()).concat(" - ").concat(producto.getNombre()));
		}
		
		
		return productoCarrito;
	}

	@Override
	public void incrementarProductoCarrito(ProductoCarrito productoCarrito) {
		productoCarrito.setQuantity((productoCarrito.getQuantity() + 1));
		this.entityManager.merge(productoCarrito);
	}

	
	@Override
	public int cantidadProductoIntoCarrito(Carrito carrito) {
		int cantidadProducto = 0;
		
		Query query = this.entityManager.createNativeQuery(SQL_CONSULTA_CANTIDAD_PRODUCTO_INTO_CARRITO.toString(), ProductoCarrito.class);
		
		try {
			query.setParameter("carrito_id", carrito.getId());
			List<ProductoCarrito> productosCarritos = (List<ProductoCarrito>) query.getResultList();
			
			for (ProductoCarrito productoCarrito : productosCarritos) {
				cantidadProducto++;
			}
		} catch (NoResultException e) {
			LOGGER.info("No hay productos en el carrito");
		} catch (NullPointerException e) {
			LOGGER.info("No hay carrito");
			return cantidadProducto;
		}
		
		
		return cantidadProducto;
	}

	@Override
	public List<ProductoFinal> listarProductosCarrito(Carrito carrito) {
		List<ProductoCarrito>productosCarrito = null;
		List<ProductoFinal> listaFinal = null;
		
		Query query = this.entityManager.createNativeQuery(SQL_CONSULTA_PRODUCTOS_POR_CARRITO.toString(), ProductoCarrito.class);
		query.setParameter("carrito_id", carrito.getId());
		
		try {
			productosCarrito = (List<ProductoCarrito>) query.getResultList();
			listaFinal = new ArrayList<>();
			
			double total = 0;
			
			for (ProductoCarrito productoCarrito : productosCarrito) {
				Producto producto = this.iProductoService.buscarProducto(productoCarrito.getProducto());
				
				BigDecimal subTotal = new BigDecimal(0);
				subTotal = producto.getSku().multiply(new BigDecimal(productoCarrito.getQuantity()));
				
				listaFinal.add(new ProductoFinal(productoCarrito, producto, subTotal));
			}
			
		} catch (NoResultException e) {
			LOGGER.info("No hay productos en el carrito");
		}
		
		
		return listaFinal;
	}

	@Override
	public void eliminarOfCarrito(Long id) {
		this.entityManager.remove(this.entityManager.find(ProductoCarrito.class, id));
		
	}

	@Override
	public void modificarCantidadOfProductoOfCarrito(Long id, Integer quantity) {
		ProductoCarrito productoCarrito = this.entityManager.find(ProductoCarrito.class, id);
		productoCarrito.setQuantity(quantity);
		this.entityManager.merge(productoCarrito);
	}
	
}
